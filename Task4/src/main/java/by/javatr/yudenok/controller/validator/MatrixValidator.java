package by.javatr.yudenok.controller.validator;

import by.javatr.yudenok.bean.Matrix;
import by.javatr.yudenok.exception.ValidatorException;

public class MatrixValidator {
    public void validate(Matrix matrix) throws ValidatorException {
        for(int i = 0; i < matrix.getMatrix().length; i++){
            if(matrix.getMatrix().length != matrix.getMatrix()[i].length ||
            matrix.getMatrix().length <= 8 || matrix.getMatrix().length >= 12 ){
                throw new ValidatorException();
            }
        }
    }
}
