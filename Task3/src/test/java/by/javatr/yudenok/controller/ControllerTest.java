package by.javatr.yudenok.controller;

import by.javatr.yudenok.controller.parser.ParserKinds;
import by.javatr.yudenok.controller.parser.XMLParser;
import by.javatr.yudenok.controller.parser.factory.ParsersFactory;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.service.CandiesPrinter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;

class ControllerTest {

    @ParameterizedTest
    @ValueSource(strings = {"DOM", "SAX", "StAX", "JAXB"})
    public void executeTask(String type) throws ParserConfigurationException,
            ParserException, SAXException, IOException,
            JAXBException, XMLStreamException, ParseException {
        XMLParser parser= ParsersFactory.parseXML(ParserKinds.valueOf(type));
        CandiesPrinter.printInfo(parser.parseXML("src/test/resources/Candies.xml"));
    }
}