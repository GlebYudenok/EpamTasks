package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingredient", propOrder = {"quantity", "name", "unit"})
public class Ingredient {
    /**
     * quantity of ingredient field.
     * double type.
     */
    @XmlElement
    private double quantity;
    /**
     * name of ingredient field.
     */
    @XmlElement
    private String name;
    /**
     * field of ingredient class.
     */
    @XmlAttribute
    private String unit;

    /**
     * constructor with all fields.
     * @param quantity set quantity
     * @param name set name
     * @param unit set unit
     */
    public Ingredient(final double quantity, final String name,
                      final String unit) {
        this.quantity = quantity;
        this.name = name;
        this.unit = unit;
    }

    /**
     * default empty constructor.
     */
    public Ingredient() {

    }

    /**
     * getter.
     * @return double value
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * setter.
     * @param quantity double
     */
    public void setQuantity(final double quantity) {
        this.quantity = quantity;
    }

    /**
     * getter.
     * @return string value
     */
    public String getName() {
        return name;
    }

    /**
     * setter.
     * @param name string value
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * getter.
     * @return string value
     */
    public String getUnit() {
        return unit;
    }

    /**
     * setter.
     * @param unit string value
     */
    public void setUnit(final String unit) {
        this.unit = unit;
    }



    @Override
    public String toString() {
        return  "name : " + name + "</br>"
                + "quantity : " + quantity + "</br>"
                + "unit : " + unit + "</br>";
    }
}