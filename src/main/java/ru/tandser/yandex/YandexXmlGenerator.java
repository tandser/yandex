package ru.tandser.yandex;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tandser.yandex.pojo.Companies;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class YandexXmlGenerator implements Processor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private CompanyMappingQuery companyMappingQuery;
    private JAXBContext         jaxbContext;

    public YandexXmlGenerator(DataSource dataSource) {
        companyMappingQuery = new CompanyMappingQuery(dataSource);
    }

    @Override
    public void process(Exchange exchange) throws Exception {

    }

    private JAXBContext initJaxbContext() throws JAXBException {
        return JAXBContextFactory.createContext(new Class[]{Companies.class}, null);
    }
}