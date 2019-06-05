package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "value", propOrder = {"unit","fat","protein","carbohydrates"})
public class Value {
    @XmlAttribute
    private String unit;
    @XmlElement
    private double fat;
    @XmlElement
    private double protein;
    @XmlElement
    private double carbohydrates;

    public Value(String unit, double fat, double protein, double carbohydrates) {
        this.unit = unit;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
    }

    public Value() {
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public String toString() {
        return "Value{" +
                "unit='" + unit + '\'' +
                ", fat=" + fat +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}

