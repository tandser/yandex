package ru.tandser.yandex.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.NONE)
public class Companies {

    private List<Company> company;

    public Companies() {}

    public Companies(List<Company> company) {
        this.company = company;
    }

    @XmlElement(name = "company")
    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }
}