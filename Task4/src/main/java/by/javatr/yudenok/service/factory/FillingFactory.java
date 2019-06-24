package by.javatr.yudenok.service.factory;

import by.javatr.yudenok.service.FillingType;
import by.javatr.yudenok.service.MatrixFiller;
import by.javatr.yudenok.service.impl.FillMatrixFromFile;
import by.javatr.yudenok.service.impl.FillMatrixRandom;

public class FillingFactory {

    /**
     * selects how to fill the array.
     * @param name enum type of method of filling
     * @return interface reference
     * @throws Exception exception
     */
    public MatrixFiller fill(final FillingType name) throws Exception {

        MatrixFiller matrixFiller = null;

        switch (name) {
            case RANDOM:
                matrixFiller = new FillMatrixRandom();
                break;
            case FILE:
                matrixFiller = new FillMatrixFromFile();
                break;
            default:
                throw new Exception("Error");
        }
        return matrixFiller;
    }
}
