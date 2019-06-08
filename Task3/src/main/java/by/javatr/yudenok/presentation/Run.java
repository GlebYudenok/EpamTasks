package by.javatr.yudenok.presentation;

import by.javatr.yudenok.controller.Controller;
import by.javatr.yudenok.controller.parser.ParserKinds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {

    private static final Logger LOGGER = LogManager.getLogger(Run.class);

    public static void main(String[] args){
        Controller controller = new Controller();
        controller.executeTask(ParserKinds.DOM, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.JAXB, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.SAX, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.StAX, "Task3\\src\\main\\resources\\Candies.xml");
    }
}
