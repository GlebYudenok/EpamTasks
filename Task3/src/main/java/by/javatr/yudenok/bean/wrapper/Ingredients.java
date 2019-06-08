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
    private List<Ingredient> ingredient = new ArrayList<>();

    public List<Ingredient> getIngredients() {
        return ingredient;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredient = ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredient.add(ingredient);
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredients=" + ingredient +
                '}';
    }
}
