package by.javatr.yudenok.service.factory;

import by.javatr.yudenok.service.FillingType;
import by.javatr.yudenok.service.MatrixFiller;
import by.javatr.yudenok.service.impl.FillMatrixRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class FillingFactory {

    public MatrixFiller fill(FillingType name) throws Exception {

        MatrixFiller matrixFiller = null;

        switch (name) {
            case RANDOM:
                matrixFiller = new FillMatrixRandom();
                break;
            default:
                throw new Exception("Error");
        }
        return matrixFiller;
    }
}
