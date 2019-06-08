package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.Candy;
import by.javatr.yudenok.controller.parser.SAXHandler;
import by.javatr.yudenok.controller.parser.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParsers implements XMLParser {
    /**
     * function that parse from xml-document to object
     * via SAX.
     * @param path path of file which will parse
     * @return list of objects
     * @throws ParserConfigurationException configuration problem exception
     * @throws IOException exception linked with file problems
     * @throws SAXException parser exception
     */
    @Override
    public List<Candy> parseXML(final String path)
            throws ParserConfigurationException, IOException, SAXException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SAXHandler handler = new SAXHandler();
        saxParser.parse(new FileInputStream(path), handler);

        List<Candy> l = new ArrayList<>();
        for (Candy candy : handler.getCandyList()) {
            l.add(candy);
        }
        return l;
    }
}
