package by.javatr.yudenok.controller.parser;

import by.javatr.yudenok.bean.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    /**
     * list of candies, in which will add objects of xml parsing.
     */
    private List<Candy> candyList = new ArrayList<>();
    /**
     * field in object which will parse.
     */
    private Ingredient ingredient = null;
    /**
     * field in object which will parse.
     */
    private CandyType candyType = null;
    /**
     * field in object which will parse.
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
     * field in object which will parse.
     */
    private Value value = null;

    /**
     * getter.
     * @return list of parsed objects.
     */
    public List<Candy> getCandyList() {
        return candyList;
    }


    /**
     * Receive notification of the start of an element.
     *
     * @param uri The Namespace URI, or the empty string if the
     *        element has no Namespace URI or if Namespace
     *        processing is not being performed.
     * @param localName The local name (without prefix), or the
     *        empty string if Namespace processing is not being
     *        performed.
     * @param qName The qualified name (with prefix), or the
     *        empty string if qualified names are not available.
     * @param attributes The attributes attached to the element.  If
     *        there are no attributes, it shall be an empty
     *        Attributes object.
     * @exception org.xml.sax.SAXException Any SAX exception, possibly
     *            wrapping another exception.
     */
    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attributes) {

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
        }
    }

    /**
     * Receive notification of the end of an element.
     *
     * @param uri The Namespace URI, or the empty string if the
     *        element has no Namespace URI or if Namespace
     *        processing is not being performed.
     * @param localName The local name (without prefix), or the
     *        empty string if Namespace processing is not being
     *        performed.
     * @param qName The qualified name (with prefix), or the
     *        empty string if qualified names are not available.
     * @exception org.xml.sax.SAXException Any SAX exception, possibly
     *            wrapping another exception.
     * @see org.xml.sax.ContentHandler#endElement
     */
    @Override
    public void endElement(final String uri,
                           final String localName, final String qName) {
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

    /**
     * Receive notification of character data inside an element.
     *
     * @param ch The characters.
     * @param start The start position in the character array.
     * @param length The number of characters to use from the
     *               character array.
     * @exception org.xml.sax.SAXException Any SAX exception, possibly
     *            wrapping another exception.
     */
    @Override
    public void characters(final char[] ch,
                           final int start, final int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }
}
