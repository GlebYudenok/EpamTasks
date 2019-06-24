package by.javatr.yudenok.controller;

import by.javatr.yudenok.service.FillerDiagonalThread;
import by.javatr.yudenok.bean.Matrix;
import by.javatr.yudenok.controller.validator.MatrixValidator;
import by.javatr.yudenok.dao.DAO;
import by.javatr.yudenok.exception.ValidatorException;
import by.javatr.yudenok.service.FillingType;
import by.javatr.yudenok.service.factory.FillingFactory;

import java.util.concurrent.locks.ReentrantLock;


public class Controller {
    /**
     * create singletone object.
     */
    private DAO instance = DAO.getINSTANCE();
    /**
     * create locker object.
     */
    private ReentrantLock lock = new ReentrantLock();

    /**
     * manager method.
     * @param command command of action
     * @throws ValidatorException throw, when matrix wrong initialized
     */
    public void executeTask(final String command) throws ValidatorException {
        switch (command) {
            case "Init":
                instance.matrix = Matrix.getInstance();
                instance.matrix.setSizeOfMatrix(10, 10, lock);
                MatrixValidator validator = new MatrixValidator();
                validator.validate(instance.matrix);
                break;
            case "Fill":
                FillingFactory fillingFactory = new FillingFactory();
                try {
                    fillingFactory.fill(FillingType.FILE).fill(instance.matrix);
                } catch (Exception e) {
                    System.err.println("Ошибка при проверке "
                            + "массива на"
                            + " соблюдение условий");
                    throw new ValidatorException();
                }
                break;
            case "Fill diagonal":
                FillerDiagonalThread filler1 = new FillerDiagonalThread(111);
                FillerDiagonalThread filler2 = new FillerDiagonalThread(222);
                FillerDiagonalThread filler3 = new FillerDiagonalThread(333);
                FillerDiagonalThread filler4 = new FillerDiagonalThread(444);
                filler4.start();
                filler1.start();
                filler2.start();
                filler3.start();

                try {
                    filler1.join();
                    filler2.join();
                    filler3.join();
                    filler4.join();
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
                break;
            case "Show":
                System.out.println(instance.matrix);
                break;
                default:
                    throw new IllegalArgumentException("Wrong type of command");
        }
    }
}
