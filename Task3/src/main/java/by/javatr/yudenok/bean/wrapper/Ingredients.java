package by.javatr.yudenok.bean.wrapper;

import by.javatr.yudenok.bean.Ingredient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingredients", propOrder = {"ingredient"})
public class Ingredients {

    /**
     * creating arraylist of object.
     */
    private List<Ingredient> ingredient = new ArrayList<>();

    /**
     * getter.
     * @return list of elements
     */
    public List<Ingredient> getIngredients() {
        return ingredient;
    }

    /**
     * setter.
     * @param ingredients list of elements
     */
    public void setIngredients(final List<Ingredient> ingredients) {
        this.ingredient = ingredients;
    }

    /**
     * add value to collection.
     * @param ingredient value for adding
     */
    public void addIngredient(final Ingredient ingredient) {
        this.ingredient.add(ingredient);
    }

    @Override
    public String toString() {
        return "Ingredients{"
                + "ingredients="
                + ingredient
                + '}';
    }
}
