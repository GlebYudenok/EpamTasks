package by.javatr.yudenok.bean;

import by.javatr.yudenok.bean.wrapper.Ingredients;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candy", propOrder = {"id", "title", "energy", "candyType",
         "ingredients", "ingredient", "value", "producer"})
public class Candy {

    /**
     * field as id of candy.
     */
    @XmlAttribute
    private String id;
    /**
     * field is name of candy.
     */
    @XmlElement
    private String title;
    /**
     * field is energy of candy.
     */
    @XmlElement
    private double energy;
    /**
     * field is candyType.
     */
    @XmlElement
    private CandyType candyType = new CandyType();
    /**
     * field is value of candy.
     */
    @XmlElementRef
    private Value value = new Value();
    /**
     * field is producer of candies.
     */
    @XmlElementRef
    private Producer producer = new Producer();
    /**
     * field is container of ingredients in array list.
     */
    @XmlElementRef
    private Ingredients ingredients = new Ingredients();
    /**
     * field is ingredient of candy.
     */
    @XmlElement
    private Ingredient ingredient = new Ingredient();

    /**
     * default constructor.
     */
    public Candy() {

    }

    /**
     * constructor with all fields.
     * @param id id of element
     * @param title title of element
     * @param energy energy of element
     * @param candyType type of candy
     * @param value value
     * @param producer producer info
     * @param ingredients ingredient list
     */
    public Candy(final String id, final String title, final double energy,
                 final CandyType candyType, final Value value,
                 final Producer producer, final Ingredients ingredients) {
        this.id = id;
        this.title = title;
        this.energy = energy;
        this.candyType = candyType;
        this.value = value;
        this.producer = producer;
        this.ingredients = ingredients;
    }

    /**
     * getter.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * setter.
     * @param id id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * getter.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter.
     * @return containter of ingredients
     */
    public Ingredients getIngredients() {
        return ingredients;
    }

    /**
     * setter.
     * @param ingredients ingredients
     */
    public void setIngredients(final Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * getter.
     * @return get one ingredient
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     * setter.
     * @param ingredient one ingredient
     */
    public void setIngredient(final Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * setter.
     * @param title title of candy
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * getter.
     * @return energy
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * setter.
     * @param energy set value
     */
    public void setEnergy(final double energy) {
        this.energy = energy;
    }

    /**
     * getter.
     * @return reference type.
     */
    public CandyType getCandyType() {
        return candyType;
    }

    /**
     * setter.
     * @param candyType reference type
     */
    public void setCandyType(final CandyType candyType) {
        this.candyType = candyType;
    }

    /**
     * getter.
     * @return reference type
     */
    public Value getValue() {
        return value;
    }

    /**
     * setter.
     * @param value reference type.
     */
    public void setValue(final Value value) {
        this.value = value;
    }

    /**
     * getter.
     * @return reference type
     */
    public Producer getProducer() {
        return producer;
    }


    /**
     * set one value to collection.
     * @param ingredient one value
     */
    public void setIngredientToIngredients(final Ingredient ingredient) {
        this.ingredients.addIngredient(ingredient);
    }

    /**
     * setter.
     * @param producer value
     */
    public void setProducer(final Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Candy{"
                + "id='" + id + '\''
                + ", title='" + title + '\''
                + ", energy=" + energy
                + ", candyType= filling: " + candyType.isFilling()
                + ", type: " + candyType.getType()
                + ", ingredients=" + ingredients
                + ", value=" + value
                + ", producer=" + producer
                + '}';
    }
}
