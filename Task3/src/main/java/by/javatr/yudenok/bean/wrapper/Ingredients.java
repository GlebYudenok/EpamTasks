package by.javatr.yudenok.bean.wrapper;

import by.javatr.yudenok.bean.Ingredient;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingredients", propOrder = {"ingredient"})
public class Ingredients {

    @XmlElementRef
    private List<Ingredient> ingredient = new ArrayList();

    public Ingredients(){

    }

    public List<Ingredient> getIngredients() {
        return ingredient;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredient = ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredient.add(ingredient);
    }

    public Ingredients(List<Ingredient> ingredients) {
        this.ingredient = ingredients;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredient=" + ingredient +
                '}';
    }
}
