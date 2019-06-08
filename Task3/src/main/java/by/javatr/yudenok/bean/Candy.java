package by.javatr.yudenok.bean;

import by.javatr.yudenok.bean.wrapper.Ingredients;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candy", propOrder = {"id","title","energy","candyType","ingredients","ingredient","value","producer"})
public class Candy {
    @XmlAttribute
    private String id;
    @XmlElement
    private String title;
    @XmlElement
    private double energy;
    @XmlElement
    private CandyType candyType = new CandyType();
    @XmlElementRef
    private Value value = new Value();
    @XmlElementRef
    private Producer producer = new Producer();
    @XmlElementRef
    private Ingredients ingredients = new Ingredients();
    @XmlElement
    private Ingredient ingredient = new Ingredient();

    public Candy(){

    }

    public Candy(String title, double energy, CandyType candyType, Ingredient ingredient, Value value, Producer producer) {
        this.title = title;
        this.energy = energy;
        this.value = value;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public CandyType getCandyType() {
        return candyType;
    }

    public void setCandyType(CandyType candyType) {
        this.candyType = candyType;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setIngredientToIngredients(Ingredient ingredient){
        this.ingredients.addIngredient(ingredient);
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", energy=" + energy +
                ", candyType=" + candyType +
                ", ingredients=" + ingredients +
                ", value=" + value +
                ", producer=" + producer +
                '}';
    }
}
