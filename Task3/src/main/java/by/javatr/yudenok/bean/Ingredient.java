package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingredient", propOrder = {"quantity","name","unit"})
public class Ingredient {
    @XmlElement
    private double quantity;
    @XmlElement
    private String name;
    @XmlAttribute
    private String unit;

    public Ingredient(double quantity, String name, String unit) {
        this.quantity = quantity;
        this.name = name;
        this.unit = unit;
    }

    public Ingredient(){

    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "quantity=" + quantity +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
