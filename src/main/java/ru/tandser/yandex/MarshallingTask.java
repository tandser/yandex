package ru.tandser.yandex;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Objects;
import java.util.concurrent.Callable;

import static java.util.Objects.requireNonNull;

/**
 * Этот класс представляет собой задачу по преобразованию объекта в
 * формат XML и предназначенную для выполнения в отдельном потоке.
 *
 * <p>Поскольку маршалинг осуществляется при помощи JAXB,
 * необходимо чтобы класс преобразуемого объекта соответствовал
 * соглашениям JAXB, а принимаемый конструктором JAXB-контекст был
 * должным образом сконфигурирован.
 *
 * <p>При преобразовании различных объектов одного класса как
 * правило разрешается пользоваться одним и тем же экземляром JAXB-
 * контекста.
 *
 * @author Andrew Timokhin
 */
public class MarshallingTask implements Callable<String> {

    private JAXBContext jaxbContext;
    private Object      source;

    public MarshallingTask(JAXBContext jaxbContext, Object source) {
        this.jaxbContext = jaxbContext;
        this.source      = source;
    }

    @Override
    public String call() throws Exception {
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(source, stringWriter);
        return stringWriter.toString();
    }
}