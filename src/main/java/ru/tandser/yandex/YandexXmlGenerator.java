package ru.tandser.yandex;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import ru.tandser.yandex.pojo.Companies;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class YandexXmlGenerator implements Processor {

    private static JAXBContext jaxbContext = initJaxbContext();

    private CompanyMappingQuery companyMappingQuery;

    public YandexXmlGenerator(DataSource dataSource) {
        companyMappingQuery = new CompanyMappingQuery(dataSource);
    }

    @Override
    public void process(Exchange exchange) throws Exception {

    }

    private static JAXBContext initJaxbContext() {
        try {
            return JAXBContextFactory.createContext(new Class[]{Companies.class}, null);
        } catch (JAXBException exc) {
            throw new RuntimeException(exc);
        }
    }
}