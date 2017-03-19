package ru.tandser.yandex.pojo;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"id", "name", "address"})
public class Company {

    private Integer id;
    private String  name;
    private String  address;

    public Company() {}

    public Company(Integer id, String name, String address) {
        this.id      = id;
        this.name    = name;
        this.address = address;
    }

    @XmlElement(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Company that = (Company) obj;

        return Objects.equals(getId(),      that.getId())   &&
               Objects.equals(getName(),    that.getName()) &&
               Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id",      getId())
                .add("name",    getName())
                .add("address", getAddress())
                .toString();
    }
}