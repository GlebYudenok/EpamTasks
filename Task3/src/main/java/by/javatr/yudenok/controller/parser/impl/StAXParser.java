package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.*;
import by.javatr.yudenok.controller.parser.XMLParser;

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
    public List<Candy> parseXML(String path) {
        return null;
    }
}
