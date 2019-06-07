package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.Candy;
import by.javatr.yudenok.controller.parser.SAXHandler;
import by.javatr.yudenok.controller.parser.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParsers implements XMLParser {

    @Override
    public List<Candy> parseXML(String path) throws ParserConfigurationException, IOException, SAXException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SAXHandler handler = new SAXHandler();
        saxParser.parse(new FileInputStream(path),handler);

        List<Candy> l = new ArrayList<>();
        for (Candy candy:
                handler.getCandyList()) {
            l.add(candy);
        }
        return l;
    }
}
