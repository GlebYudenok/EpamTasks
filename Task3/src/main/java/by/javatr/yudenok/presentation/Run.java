package by.javatr.yudenok.presentation;

import by.javatr.yudenok.bean.Candy;
import by.javatr.yudenok.controller.Controller;
import by.javatr.yudenok.controller.parser.ParserKinds;
import by.javatr.yudenok.controller.parser.SAXHandler;
import by.javatr.yudenok.controller.parser.impl.JAXBParser;
import by.javatr.yudenok.controller.parser.impl.SAXParsers;
import by.javatr.yudenok.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.*;
import java.util.List;

public class Run {

    private static final Logger LOGGER = LogManager.getLogger(Run.class);

    public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParserException {
        Controller controller = new Controller();
        controller.executeTask(ParserKinds.DOM, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.JAXB, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.SAX, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.StAX, "Task3\\src\\main\\resources\\Candies.xml");
    }
}
