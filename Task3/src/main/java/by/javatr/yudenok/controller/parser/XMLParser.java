package by.javatr.yudenok.controller.parser;

import by.javatr.yudenok.bean.Candy;
import by.javatr.yudenok.exception.ParserException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface XMLParser {
    List<Candy> parseXML(String path) throws JAXBException, ParserException, ParserConfigurationException, IOException, SAXException;
}
