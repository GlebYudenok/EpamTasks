package by.javatr.yudenok.bean;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum  TypeOfCandy {
    /**
     * enum elements.
     */
    CARAMEL("CARAMEL"),
    /**
     * enum elements.
     */
    CHOCOLATE("CHOCOLATE"),
    /**
     * enum elements.
     */
    SUGAR("SUGAR"),
    /**
     * enum elements.
     */
    CHEWING("CHEWING"),
    /**
     * enum elements.
     */
    MARMALADE("MARMALADE"),
    /**
     * enum elements.
     */
    MARSHMALLOW("MARSHMALLOW");

    /**
     * string field of each value of enumeration.
     */
    private final String type;

    /**
     * constructor of enumeration.
     * @param type string value
     */
    TypeOfCandy(final String type) {
        this.type = type;
    }
}
