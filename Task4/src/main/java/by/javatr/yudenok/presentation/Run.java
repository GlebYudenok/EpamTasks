package by.javatr.yudenok.presentation;

import by.javatr.yudenok.bean.Matrix;
import by.javatr.yudenok.controller.Controller;
import by.javatr.yudenok.controller.validator.MatrixValidator;
import by.javatr.yudenok.exception.ValidatorException;
import by.javatr.yudenok.service.FillingType;
import by.javatr.yudenok.service.factory.FillingFactory;

public class Run {
    public static void main(String[] args){
        Controller controller = new Controller();
        try {
            controller.executeTask("Init");
            controller.executeTask("Fill");
            controller.executeTask("Show");
        }catch (ValidatorException e){
            System.out.println("Error");
        }
    }
}
