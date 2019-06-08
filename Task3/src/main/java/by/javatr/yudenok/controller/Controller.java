package by.javatr.yudenok.controller;

import by.javatr.yudenok.controller.parser.ParserKinds;
import by.javatr.yudenok.controller.parser.XMLParser;
import by.javatr.yudenok.controller.parser.factory.ParsersFactory;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.printer.CandiesPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;

public class Controller {

    private XMLParser parser = null;
    private final static Logger LOGGER = LogManager.getLogger(Controller.class);

    public void executeTask(ParserKinds parserKinds, String path){

        LOGGER.info("Parse via " + parserKinds + "...");
        parser = ParsersFactory.parseXML(parserKinds);
        try {
            CandiesPrinter.printInfo(parser.parseXML(path));
        } catch (JAXBException | ParserException | ParserConfigurationException | IOException | SAXException | XMLStreamException | ParseException e) {
            LOGGER.error(e);
            System.err.println("Error");
        }
    }
}
