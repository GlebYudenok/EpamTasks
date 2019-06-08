package by.javatr.yudenok.controller.parser;

import by.javatr.yudenok.bean.Candy;
import by.javatr.yudenok.exception.ParserException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface XMLParser {
    /**
     * parse xml element via different kinds of parsers.
     * @param path path of file which will parse
     * @return list of parsed objects
     * @throws JAXBException JAXB parser exception
     * @throws ParserException parser exception
     * @throws ParserConfigurationException configuration parser exception
     * @throws IOException exception linked with file problem
     * @throws SAXException SAX parser exception
     * @throws XMLStreamException stream exceptions
     * @throws ParseException parse exception
     */
    List<Candy> parseXML(String path) throws JAXBException,
            ParserException, ParserConfigurationException,
            IOException, SAXException, XMLStreamException,
            ParseException;
}
