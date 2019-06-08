package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.*;
import java.util.Calendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producer", propOrder = {"country","enterprise", "foundingDate"})
public class Producer {

    @XmlAttribute
    private String country;
    @XmlElement
    private String enterprise;
    @XmlElement
    Calendar foundingDate = Calendar.getInstance();

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

    public Calendar getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(Calendar foundingDate) {
        this.foundingDate = foundingDate;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "country='" + country + '\'' +
                ", enterprise='" + enterprise + '\'' +
                ", foundingDate=" + foundingDate.get(Calendar.YEAR) +
                "-"  + foundingDate.get(Calendar.MONTH) + "-" +
                foundingDate.get(Calendar.DAY_OF_MONTH) +
                '}';
    }
}
