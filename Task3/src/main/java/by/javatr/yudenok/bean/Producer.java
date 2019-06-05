package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.*;
import java.util.function.Predicate;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producer", propOrder = {"country","enterprise"})
public class Producer {
    @XmlAttribute
    private String country;
    @XmlElement
    private String enterprise;

    public Producer(String country, String enterprise) {
        this.country = country;
        this.enterprise = enterprise;
    }

    public Producer(){

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "country='" + country + '\'' +
                ", enterprise='" + enterprise + '\'' +
                '}';
    }
}
