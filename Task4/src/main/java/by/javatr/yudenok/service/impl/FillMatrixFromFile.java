package by.javatr.yudenok.service.impl;

import by.javatr.yudenok.bean.Matrix;
import by.javatr.yudenok.dao.DAO;
import by.javatr.yudenok.service.MatrixFiller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class FillMatrixFromFile implements MatrixFiller {

    /**
     * Logger for write information.
     */
    private Logger logger = LogManager.getLogger(FillMatrixRandom.class);

    /**
     * path of file, which contains numbers for matrix.
     */
    private String path = "Task4\\src\\main\\resources\\file";

    /**
     * overriding method, which filling the matrix different ways.
     * @param matrix matrix object
     */
    @Override
    public void fill(final Matrix matrix) {
        logger.info("Matrix is filled from file");
        try {
            DAO.getINSTANCE().read(path);
        } catch (IOException e) {
            logger.error("Wrong file");
            System.err.println("Error. Wrong file.");
        }
    }
}
