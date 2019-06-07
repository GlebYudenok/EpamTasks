package by.javatr.yudenok.controller.parser;

import by.javatr.yudenok.bean.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Candy> candyList = new ArrayList<>();
    private Ingredient ingredient = null;
    private CandyType candyType = null;
    private Producer producer = null;
    private Candy candy = null;
    private String content = null;
    private Value value = null;

    public List<Candy> getCandyList() {
        return candyList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        switch (qName) {
            case "candy":
                candy = new Candy();
                candy.setId(attributes.getValue("id"));
                break;
            case "ingredient":
                ingredient = new Ingredient();
                ingredient.setUnit(attributes.getValue("unit"));
                break;
            case "value":
                value = new Value();
                value.setUnit(attributes.getValue("unit"));
                break;
            case "producer":
                producer = new Producer();
                producer.setCountry(attributes.getValue("country"));
                break;
                default:
                    //exception
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "candy":
                candyList.add(candy);
                break;
            case "title":
                candy.setTitle(content);
                break;
            case "energy":
                candy.setEnergy(Integer.parseInt(content));
                break;
            case "filling":
                candyType.setFilling(Boolean.valueOf(content));
                candy.setCandyType(candyType);
                break;
            case "type":
                candyType = new CandyType();
                candyType.setType(TypeOfCandy.valueOf(content));
                break;
            case "name":
                ingredient.setName(content);
                candy.setIngredientToIngredients(ingredient);
                break;
            case "quantity":
                ingredient.setQuantity(Double.parseDouble(content));
                break;
            case "fat":
                value.setFat(Double.parseDouble(content));
                break;
            case "protein":
                value.setProtein(Double.parseDouble(content));
                break;
            case "carbohydrates":
                value.setCarbohydrates(Double.parseDouble(content));
                candy.setValue(value);
                break;
            case "enterprise":
                producer.setEnterprise(content);
                candy.setProducer(producer);
                break;
                default:
                    //exception
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }
}
