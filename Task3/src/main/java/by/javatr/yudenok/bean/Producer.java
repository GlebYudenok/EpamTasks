package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.*;
import java.util.Calendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producer", propOrder = {"country", "enterprise",
        "foundingDate"})
public class Producer {

    /**
     * string field.
     */
    @XmlAttribute
    private String country;
    /**
     * string field.
     */
    @XmlElement
    private String enterprise;
    /**
     * instance of Calendar class as field.
     */
    @XmlElement
    private Calendar foundingDate = Calendar.getInstance();

    /**
     * constructor with all fields.
     * @param country string
     * @param enterprise string
     * @param foundingDate calendar
     */
    public Producer(final String country, final String enterprise,
                    final Calendar foundingDate) {
        this.country = country;
        this.enterprise = enterprise;
        this.foundingDate = foundingDate;
    }

    /**
     * default empty constructor.
     */
    public Producer() {

    }

    /**
     * getter.
     * @return string
     */
    public String getCountry() {
        return country;
    }

    /**
     * setter.
     * @param country string value
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * getter.
     * @return string
     */
    public String getEnterprise() {
        return enterprise;
    }

    /**
     * setter.
     * @param enterprise string value
     */
    public void setEnterprise(final String enterprise) {
        this.enterprise = enterprise;
    }

    /**
     * getter.
     * @return calendar ad date format
     */
    public Calendar getFoundingDate() {
        return foundingDate;
    }

    /**
     * setter.
     * @param foundingDate calendar instance
     * in several date format
     */
    public void setFoundingDate(final Calendar foundingDate) {
        this.foundingDate = foundingDate;
    }

    @Override
    public String toString() {
        return  "country: " + country + "</br>"
                + "enterprise: " + enterprise + "</br>"
                + "foundingDate: " + foundingDate.get(Calendar.YEAR)
                + "-"  + foundingDate.get(Calendar.MONTH)
                + "-" + foundingDate.get(Calendar.DAY_OF_MONTH);
    }
}
