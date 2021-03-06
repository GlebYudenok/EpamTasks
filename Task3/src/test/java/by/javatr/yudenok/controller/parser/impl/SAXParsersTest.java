package by.javatr.yudenok.controller.parser.impl;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SAXParsersTest {

    public SAXParsers saxParsers = new SAXParsers();

    List<String> paths = Arrays.asList("src\\test\\resources\\Candies.xml",
            "src\\test\\resources\\EmptyFile.xml",
            "src\\test\\resources\\WrongCandies.xml",
            "wrongPath.xml");

    @Test
    public void parseIdeal() throws IOException, SAXException, ParserConfigurationException {
        saxParsers.parseXML(paths.get(0)).forEach(System.out::println);
    }

    @Test(expected = SAXParseException.class)
    public void parseEmptyFile() throws IOException, SAXException, ParserConfigurationException {
        saxParsers.parseXML(paths.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void parseWrongFile() throws IOException, SAXException, ParserConfigurationException {
        saxParsers.parseXML(paths.get(2));
    }

    @Test(expected = FileNotFoundException.class)
    public void parseWrongPath() throws IOException, SAXException, ParserConfigurationException {
        saxParsers.parseXML(paths.get(3));
    }
}