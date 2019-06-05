package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum  TypeOfCandy {
    CARAMEL("CARAMEL"),
    CHOCOLATE("CHOCOLATE"),
    SUGAR("SUGAR"),
    CHEWING("CHEWING");

    private final String type;

    TypeOfCandy(String type) {
        this.type = type;
    }
}
