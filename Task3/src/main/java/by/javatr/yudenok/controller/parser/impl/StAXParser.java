package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.*;
import by.javatr.yudenok.controller.parser.XMLParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StAXParser implements XMLParser {

    List<Candy> candyList = new ArrayList<>();
    Ingredient ingredient = null;
    CandyType candyType = null;
    Producer producer = null;
    Candy candy = null;
    String content = null;
    Value value = null;

    @Override
    public List<Candy> parseXML(String path) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileReader(path));

        while (xmlStreamReader.hasNext()) {
            int event = xmlStreamReader.next();
            switch (event) {
                case XMLStreamConstants
                        .START_ELEMENT:
                    switch (xmlStreamReader.getLocalName()) {
                        case "candy":
                            candy = new Candy();
                            candy.setId(xmlStreamReader.getAttributeValue(0));
                            break;
                        case "ingredient":
                            ingredient = new Ingredient();
                            ingredient.setUnit(xmlStreamReader.getAttributeValue(0));
                            break;
                        case "value":
                            value = new Value();
                            value.setUnit(xmlStreamReader.getAttributeValue(0));
                            break;
                        case "producer":
                            producer = new Producer();
                            producer.setCountry(xmlStreamReader.getAttributeValue(0));
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    content = xmlStreamReader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT: {
                    switch (xmlStreamReader.getLocalName()) {
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
                    }
                }
                break;
                case XMLStreamReader.START_DOCUMENT:
                    candyList = new ArrayList<>();
                    break;
            }
        }
        return candyList;
    }
}
