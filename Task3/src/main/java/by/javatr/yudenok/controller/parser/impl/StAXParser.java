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
import java.util.Calendar;
import java.util.List;

public class StAXParser implements XMLParser {

    /**
     * list of candies, by which will add candies.
     */
    private List<Candy> candyList = new ArrayList<>();
    /**
     * field for adding to candy object.
     */
    private Ingredient ingredient = null;
    /**
     * field for adding to candy object.
     */
    private CandyType candyType = null;
    /**
     * field for adding to candy object.
     */
    private Producer producer = null;
    /**
     * candy object int which will add other fields of this object.
     */
    private Candy candy = null;
    /**
     * field, which take datas from xml as string.
     */
    private String content = null;
    /**
     * field for adding to candy object.
     */
    private Value value = null;

    /**
     * parse xml-document to object via StAX, and do it line by line.
     * @param path path of file which will parse
     * @return list of object which will parse
     * @throws FileNotFoundException exception if path is wronng
     * @throws XMLStreamException xml exception
     */
    @Override
    public List<Candy> parseXML(final String path) throws
            FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory =
                XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader =
                xmlInputFactory.createXMLStreamReader(new FileReader(path));

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
                            ingredient.setUnit(
                                    xmlStreamReader.getAttributeValue(0));
                            break;
                        case "value":
                            value = new Value();
                            value.setUnit(xmlStreamReader.getAttributeValue(0));
                            break;
                        case "producer":
                            producer = new Producer();
                            producer.setCountry(
                                    xmlStreamReader.getAttributeValue(0));
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
                            break;
                        case "foundingDate":
                            Calendar calendar = Calendar.getInstance();
                            String[] strs = content.split("-");

                            calendar.set(Integer.parseInt(strs[0]),
                                    Integer.parseInt(strs[1]),
                                    Integer.parseInt(strs[2]));

                            producer.setFoundingDate(calendar);
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
