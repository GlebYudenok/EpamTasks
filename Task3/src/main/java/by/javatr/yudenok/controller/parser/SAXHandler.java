package by.javatr.yudenok.controller.parser;

import by.javatr.yudenok.bean.*;
import by.javatr.yudenok.bean.wrapper.Ingredients;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    List<Candy> candyList = new ArrayList<>();
    Ingredients ingredients = new Ingredients();
    Ingredient ingredient = null;
    CandyType candyType = null;
    Producer producer = null;
    Candy candy = null;
    String content = null;
    Value value = null;

    public List<Candy> getCandyList() {
        return candyList;
    }

    public void setCandyList(List<Candy> candyList) {
        this.candyList = candyList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){

        switch (qName) {
            case "candy":
                candy = new Candy();
                candy.setId(attributes.getValue("id"));
                break;
            case "ingredient":
                ingredient = new Ingredient();
                ingredient.setUnit(attributes.getValue("unit"));
                ingredients.addIngredient(ingredient);
                candy.setIngredients(ingredients);
                break;
            case "producer":
                producer = new Producer();
                producer.setCountry(attributes.getValue("country"));
                candy.setProducer(producer);
                break;
            case "value":
                value = new Value();
                value.setUnit(attributes.getValue("unit"));
                candy.setValue(value);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        switch (qName){
            case "candy":
                candyList.add(candy);
                break;
            case "title":
                candy.setTitle(content);
                break;
            case "energy":
                candy.setEnergy(Integer.parseInt(content));
                break;
        }
    }

    @Override
    public void characters(char []ch, int start, int length){
        content = String.copyValueOf(ch, start, length).trim();
    }
}
