package by.javatr.yudenok.presentation;

import by.javatr.yudenok.controller.parser.ParserKinds;
import by.javatr.yudenok.controller.*;

public class Run {

    public static void main(String[] args){
        Controller controller = new Controller();
        controller.executeTask(ParserKinds.DOM, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.JAXB, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.SAX, "Task3\\src\\main\\resources\\Candies.xml");
    }
}
