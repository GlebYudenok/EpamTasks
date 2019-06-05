package by.javatr.yudenok.bean.wrapper;

import by.javatr.yudenok.bean.Candy;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candies", propOrder = {"candy"})
public class Candies {

    public static final Candies instance = new Candies();

    public Candies(){

    }

    @XmlElement
    private List<Candy> candy = new ArrayList<>();

    public Candies(List<Candy> candyList) {
        this.candy = candyList;
    }

    public List<Candy> getCandyList() {
        return candy;
    }

    public void setCandyList(List<Candy> candyList) {
        this.candy = candyList;
    }

    @Override
    public String toString() {
        return "Candies{" +
                "candy=" + candy +
                '}';
    }
}
