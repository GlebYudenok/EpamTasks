package by.javatr.yudenok.presentation;

import by.javatr.yudenok.controller.Controller;
import by.javatr.yudenok.controller.parser.ParserKinds;

public class Run extends Thread{

    public void run(){
        Controller controller = new Controller();
        controller.executeTask(ParserKinds.DOM, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.JAXB, "Task3\\src\\main\\resources\\Candies.xml");
        controller.executeTask(ParserKinds.SAX, "Task3\\src\\main\\resources\\Candies.xml");
    }

    public static void main(String[] args){
        Run run = new Run();
        run.start();
    }
}
