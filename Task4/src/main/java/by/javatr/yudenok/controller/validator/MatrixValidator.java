package by.javatr.yudenok.controller.validator;

import by.javatr.yudenok.bean.Matrix;
import by.javatr.yudenok.exception.ValidatorException;

public class MatrixValidator {
    /**
     * minimum amount of matrix raws or columns.
     */
    private static final int MIN_SIZE = 8;
    /**
     * maximum amount of matrix raws or columns.
     */
    private static final int MAX_SIZE = 12;
    /**
     * check matrix for compliance.
     * @param matrix Matrix object
     * @throws ValidatorException throw, if wrong matrix
     */
    public void validate(final Matrix matrix) throws ValidatorException {
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            if (matrix.getMatrix().length != matrix.getMatrix()[i].length
                    || matrix.getMatrix().length < MIN_SIZE
                    || matrix.getMatrix().length > MAX_SIZE) {
                throw new ValidatorException();
            }
        }
    }
}
