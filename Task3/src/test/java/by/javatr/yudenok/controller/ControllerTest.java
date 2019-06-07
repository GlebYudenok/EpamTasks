package by.javatr.yudenok.controller;

import by.javatr.yudenok.bean.TypeOfCandy;
import by.javatr.yudenok.controller.parser.ParserKinds;
import by.javatr.yudenok.controller.parser.XMLParser;
import by.javatr.yudenok.controller.parser.factory.ParsersFactory;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.printer.CandiesPrinter;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
class ControllerTest {

    @ParameterizedTest
    @ValueSource(strings = {"DOM", "SAX", "StAX", "JAXB"})
    public void executeTask(String type) throws ParserConfigurationException, ParserException, SAXException, IOException, JAXBException, XMLStreamException {
        XMLParser parser= ParsersFactory.parseXML(ParserKinds.valueOf(type));
        CandiesPrinter.printInfo(parser.parseXML("src/test/resources/Candies.xml"));
    }
}