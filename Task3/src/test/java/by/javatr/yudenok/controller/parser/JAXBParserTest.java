package by.javatr.yudenok.controller.parser;

import by.javatr.yudenok.controller.parser.impl.JAXBParser;
import by.javatr.yudenok.exception.ParserException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JAXBParserTest {

    public JAXBParser jaxbParser = new JAXBParser();

    List<String> paths = Arrays.asList("src\\test\\resources\\Candies.xml",
            "src\\test\\resources\\EmptyFile.xml",
            "src\\test\\resources\\WrongCandies.xml",
            "wrongPath.xml");

    @Test
    public void parseIdeal() throws ParserException {
        jaxbParser.parseXML(paths.get(0)).forEach(System.out::println);
    }

    @Test(expected = ParserException.class)
    public void parseEmptyFile() throws ParserException {
        jaxbParser.parseXML(paths.get(1));
    }

    @Test(expected = ParserException.class)
    public void parseWrongFile() throws ParserException {
        jaxbParser.parseXML(paths.get(2));
    }

    @Test(expected = ParserException.class)
    public void parseWrongPath() throws ParserException {
        jaxbParser.parseXML(paths.get(3));
    }

}