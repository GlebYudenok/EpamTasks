package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type", propOrder = {"type","filling"})//, propOrder = {"CARAMEL","CHOCOLATE","SUGAR","CHEWING","filling"})
@XmlRootElement
public class CandyType {

    @XmlElement
    private boolean filling;
    @XmlElement
    private TypeOfCandy type;

    public TypeOfCandy getType() {
        return type;
    }

    public void setType(TypeOfCandy type) {
        this.type = type;
    }

    public boolean isFilling() {
        return filling;
    }

    public void setFilling(boolean filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "CandyType{" +
                "filling=" + filling +
                ", type=" + type +
                '}';
    }
}
