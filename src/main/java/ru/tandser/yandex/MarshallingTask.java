package ru.tandser.yandex;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;

/**
 * Этот класс представляет собой задачу по преобразованию объекта в
 * формат XML в виде массива байтов со сжатыми gzip-данными и
 * предназначенную для выполнения в отдельном потоке.
 *
 * <p>Поскольку маршалинг осуществляется при помощи JAXB,
 * необходимо чтобы класс преобразуемого объекта соответствовал
 * соглашениям JAXB, а принимаемый конструктором JAXB-контекст был
 * должным образом сконфигурирован.
 *
 * <p>Класс {@link JAXBContext} потокобезопасен, поэтому JAXB-
 * контекст может быть создан однажды и использоваться повторно,
 * чтобы избежать затрат на инициализацию метаданных несколько раз.
 *
 * @author Andrew Timokhin
 */
public class MarshallingTask implements Callable<ByteArrayOutputStream> {

    // увеличиваем размер буфера GZIPOutputStream с 512 байт до 8 Кбайт
    private static final int BUFFER_SIZE = 8 * 1024;

    private JAXBContext jaxbContext;
    private Object      source;

    public MarshallingTask(JAXBContext jaxbContext, Object source) {
        this.jaxbContext = jaxbContext;
        this.source      = source;
    }

    @Override
    public ByteArrayOutputStream call() throws Exception {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteOutputStream, BUFFER_SIZE)) {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(source, gzipOutputStream);
            return byteOutputStream;
        }
    }
}