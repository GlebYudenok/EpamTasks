package by.javatr.yudenok.controller;

import by.javatr.yudenok.bean.Matrix;
import by.javatr.yudenok.dao.DAO;
import by.javatr.yudenok.exception.ValidatorException;
import by.javatr.yudenok.service.FillingType;
import by.javatr.yudenok.service.factory.FillingFactory;


public class Controller {

    public void executeTask(String command) throws ValidatorException {
        switch (command){
            case "Init":
                DAO.matrix = new Matrix(3,3);
                break;
            case "Fill":
                FillingFactory fillingFactory = new FillingFactory();
                try {
                    fillingFactory.fill(FillingType.RANDOM).fill(DAO.matrix);
                } catch (Exception e) {
                    throw new ValidatorException();
                }
                break;
            case "Show":
                System.out.println(DAO.matrix);
                break;
        }
    }
}
