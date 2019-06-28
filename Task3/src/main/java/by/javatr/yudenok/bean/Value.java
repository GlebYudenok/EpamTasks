package by.javatr.yudenok.bean;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "value", propOrder = {"unit", "fat", "protein",
        "carbohydrates"})
public class Value {
    /**
     * string field.
     */
    @XmlAttribute
    private String unit;
    /**
     * double field.
     */
    @XmlElement
    private double fat;
    /**
     * double field.
     */
    @XmlElement
    private double protein;
    /**
     * double field.
     */
    @XmlElement
    private double carbohydrates;

    /**
     * constructor with all fields.
     * @param unit string
     * @param fat double
     * @param protein double
     * @param carbohydrates double
     */
    public Value(final String unit, final double fat,
                 final double protein, final double carbohydrates) {
        this.unit = unit;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
    }

    /**
     * default empty constructor.
     */
    public Value() {
    }
    /**
     * getter.
     * @return string value.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * simple setter.
     * @param unit unit
     */
    public void setUnit(final String unit) {
        this.unit = unit;
    }
    /**
     * getter.
     * @return double value.
     */
    public double getFat() {
        return fat;
    }

    /**
     * setter.
     * @param fat double value.
     */
    public void setFat(final double fat) {
        this.fat = fat;
    }

    /**
     * getter.
     * @return double value.
     */
    public double getProtein() {
        return protein;
    }

    /**
     * setter.
     * @param protein double value.
     */
    public void setProtein(final double protein) {
        this.protein = protein;
    }

    /**
     * getter.
     * @return double value.
     */
    public double getCarbohydrates() {
        return carbohydrates;
    }

    /**
     * setter.
     * @param carbohydrates double value.
     */
    public void setCarbohydrates(final double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    /**
     * Object representation as string.
     * @return
     */
    @Override
    public String toString() {
        return "unit: " + unit + "</br>"
                + "fat: " + fat + "</br>"
                + "protein: " + protein + "</br>"
                + "carbohydrates: " + carbohydrates;
    }
}

