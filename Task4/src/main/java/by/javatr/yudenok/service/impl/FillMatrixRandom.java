package by.javatr.yudenok.service.impl;

import by.javatr.yudenok.bean.Matrix;
import by.javatr.yudenok.service.MatrixFiller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class FillMatrixRandom implements MatrixFiller {

    private Logger LOGGER = LogManager.getLogger(FillMatrixRandom.class);

    public void fill(Matrix matrix){
        LOGGER.info("Matrix is filled");
        Random random = new Random();
        for(int i = 0; i < matrix.getMatrix().length; i++){
            for(int j = 0; j < matrix.getMatrix()[i].length; j++){
                matrix.getMatrix()[i][j] = random.nextInt(50);
                if(i == j){
                    matrix.getMatrix()[i][j] = 0;
                }
            }
        }
    }
}
