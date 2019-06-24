package by.javatr.yudenok.presentation;

import by.javatr.yudenok.controller.Controller;
import by.javatr.yudenok.exception.ValidatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {
    private final static Logger LOGGER = LogManager.getLogger(Run.class);
    public static void main(String[] args){
        Controller controller = new Controller();
        try {
            controller.executeTask("Init");
            controller.executeTask("Fill");
            controller.executeTask("Show");
        }catch (ValidatorException e){
            LOGGER.error("Ошибка при инициализации и заполеннии матрицы " + e);
            System.err.println("Ошибка при инициализации и заполнении массива");
        }

        try {
            controller.executeTask("Fill diagonal");
            controller.executeTask("Show");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }
}
