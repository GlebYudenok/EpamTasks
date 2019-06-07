package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.*;
import by.javatr.yudenok.bean.wrapper.Ingredients;
import by.javatr.yudenok.controller.parser.XMLParser;
import by.javatr.yudenok.exception.ParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DOMParser implements XMLParser {

    @Override
    public List<Candy> parseXML(String path) throws ParserException, ParseException {

        List<Candy> candies = new ArrayList<>();

        File file = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException();
        }
        Document document = null;

        try {
            document = documentBuilder.parse(file);
        } catch (SAXException | IOException e) {
            throw new ParserException();
        }

        NodeList candyNodeList = document.getDocumentElement().getElementsByTagName("candy");

        for(int i = 0; i < candyNodeList.getLength(); i++){
            Candy candy = new Candy();
            Node candyNode = candyNodeList.item(i);
            if(candyNode instanceof Element){
                candy.setId(candyNode.getAttributes().getNamedItem("id").getNodeValue());
                NodeList nameNodeList = candyNode.getChildNodes();
                for(int j = 0; j < nameNodeList.getLength(); j++){
                    Node node = nameNodeList.item(j);
                    if(node instanceof Element){
                        String content = node.getLastChild().getNodeValue().trim();
                        switch (node.getNodeName()){
                            case "title":
                                candy.setTitle(content);
                                break;
                            case "energy":
                                candy.setEnergy(Double.parseDouble(content));
                                break;
                            case "candyType":
                            {
                                NodeList candyTypeNodeList = node.getChildNodes();

                                CandyType candyType = new CandyType();

                                for(int k = 0; k < candyTypeNodeList.getLength(); k++){
                                    Node node1 = candyTypeNodeList.item(k);
                                    if(node1 instanceof Element){

                                        String content1 = node1.getLastChild().getNodeValue().trim();
                                        switch (node1.getNodeName()){
                                            case "type":
                                                candyType.setType(TypeOfCandy.valueOf(content1));
                                                break;
                                            case "filling":
                                                candyType.setFilling(Boolean.valueOf(content1));
                                                break;
                                            default:
                                                throw new ParserException();
                                        }
                                        candy.setCandyType(candyType);
                                    }
                                }
                            }
                            break;
                            case "ingredients":
                            {
                                NodeList ingredienList = ((Element) node).getElementsByTagName("ingredient");

                                Ingredients ingredients = new Ingredients();

                                for(int k = 0; k < ingredienList.getLength(); k++){
                                    Node node1 = ingredienList.item(k);
                                    if(node1 instanceof Element){
                                        Ingredient ingredient = new Ingredient();
                                        ingredient.setUnit(node1.getAttributes().getNamedItem("unit").getNodeValue());

                                        NodeList ingredList = node1.getChildNodes();

                                        for(int l = 0; l < ingredList.getLength(); l++){
                                            Node node2 = ingredList.item(l);
                                            if(node2 instanceof Element){
                                                String content1 = node2.getLastChild().getNodeValue();

                                                switch (node2.getNodeName()){
                                                    case "quantity":
                                                        ingredient.setQuantity(Double.parseDouble(content1));
                                                        break;
                                                    case "name":
                                                        ingredient.setName(content1);
                                                        break;
                                                    default:
                                                        throw new ParserException();
                                                }
                                            }
                                        }

                                        ingredients.addIngredient(ingredient);
                                    }
                                }
                                candy.setIngredients(ingredients);
                            }
                            break;
                            case "value":{
                                Value value = new Value();
                                value.setUnit(node.getAttributes().getNamedItem("unit").getNodeValue());

                                NodeList valueNodeList = node.getChildNodes();
                                for(int k = 0; k < valueNodeList.getLength(); k++){
                                    Node valueNode = valueNodeList.item(k);
                                    if(valueNode instanceof Element){
                                        String content1 = valueNode.getLastChild().getNodeValue();
                                        switch (valueNode.getNodeName()){
                                            case "fat":
                                                value.setFat(Double.parseDouble(content1));
                                                break;
                                            case "protein":
                                                value.setProtein(Double.parseDouble(content1));
                                                break;
                                            case "carbohydrates":
                                                value.setCarbohydrates(Double.parseDouble(content1));
                                                break;
                                            default:
                                                throw new ParserException();
                                        }
                                    }
                                }

                                candy.setValue(value);
                            }
                            break;
                            case "producer": {
                                Producer producer = new Producer();
                                producer.setCountry(node.getAttributes().getNamedItem("country").getNodeValue());

                                NodeList nodeList = node.getChildNodes();
                                for(int k = 0; k < nodeList.getLength(); k++){
                                    Node node1 = nodeList.item(k);
                                    if(node1 instanceof Element){
                                        String content1 = node1.getLastChild().getNodeValue();
                                        if(node1.getNodeName() == "enterprise"){
                                            producer.setEnterprise(content1);
                                        }
                                        if(node1.getNodeName() == "foundingDate") {
                                            Calendar calendar = Calendar.getInstance();
                                            String strs[] = content1.split("-");

                                            calendar.set(Integer.parseInt(strs[0]),
                                                    Integer.parseInt(strs[1]),
                                                    Integer.parseInt(strs[2]));

                                            producer.setFoundingDate(calendar);
                                        }
                                    }
                                }
                                candy.setProducer(producer);
                            }
                            break;
                        }
                    }
                }
            }
            candies.add(candy);
        }
        return candies;
    }
}
