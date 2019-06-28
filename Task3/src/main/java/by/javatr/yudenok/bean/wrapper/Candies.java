package by.javatr.yudenok.bean.wrapper;

import by.javatr.yudenok.bean.Candy;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candies", propOrder = {"candy"})
public class Candies {

    /**
     * singletone.
     */
    public static final Candies INSTANCE = new Candies();

    /**
     * default constructor.
     */
    public Candies() {

    }

    /**
     * creating array list of candies.
     */
    @XmlElement
    private List<Candy> candy = new ArrayList<>();

    /**
     * constructor.
     * @param candyList list of candies
     */
    public Candies(final List<Candy> candyList) {
        this.candy = candyList;
    }

    /**
     * simple getter for get value.
     * @return list of candies
     */
    public List<Candy> getCandyList() {
        return candy;
    }

    /**
     * simple setter for set value.
     * @param candyList list of candies
     */
    public void setCandyList(final List<Candy> candyList) {
        this.candy = candyList;
    }

    /**
     * Object represent as string.
     * @return
     */
    @Override
    public String toString() {
        return "Candies{"
                + "candy=" + candy
                + '}';
    }
}
