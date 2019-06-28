package by.javatr.yudenok.bean;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type", propOrder = {"type", "filling"})
@XmlRootElement
public class CandyType {

    /**
     * boolean field.
     */
    @XmlElement
    private boolean filling;
    /**
     * enumeration type.
     */
    @XmlElement
    private TypeOfCandy type;

    /**
     * getter.
     * @return reference type.
     */
    public TypeOfCandy getType() {
        return type;
    }

    /**
     * setter.
     * @param type enum type
     */
    public void setType(final TypeOfCandy type) {
        this.type = type;
    }

    /**
     * boolean setter.
     * @return true false
     */
    public boolean isFilling() {
        return filling;
    }

    /**
     * boolean setter.
     * @param filling boolean value
     */
    public void setFilling(final boolean filling) {
        this.filling = filling;
    }

    /**
     * Object represent as string.
     * @return
     */
    @Override
    public String toString() {
        return "Filling: " + filling + "</br>type: " + type;
    }
}
