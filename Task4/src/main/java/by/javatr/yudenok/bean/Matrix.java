package by.javatr.yudenok.bean;

import by.javatr.yudenok.dao.DAO;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;

public final class Matrix {

    /**
     * singleton object.
     */
    private static Matrix INSTANCE = null;
    /**
     * matrix as two-dimensional array.
     */
    private int[][] matrix;
    /**
     * Lock class object.
     */
    private Lock locker = null;

    /**
     * default constructor with default size.
     */
    private Matrix() {
        matrix = new int[8][8];
    }

    /**
     * singleton implementation.
     * @return Matrix object
     */
    public static Matrix getInstance() {
        if (INSTANCE == null) {
            synchronized (DAO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Matrix();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * get matrix.
     * @return two-dimensional array
     */
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * set matrix.
     * @param matrix two-dimensional array
     */
    public void setMatrix(final int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * init size of matrix and locker.
     * @param rows amount of rows in matrix
     * @param columns amount of columns in matrix
     * @param lock locker for safety and synchronized threads
     */
    public void setSizeOfMatrix(final int rows,
                                final int  columns, final Lock lock) {
        this.locker = lock;
        matrix = new int[rows][columns];
    }

    /**
     * function that change value of array by thread.
     * @param threadN value, that will be equal zero
     * @param threadName name of thread, which will change value
     */
    public void changeValue(final int threadN, final String threadName) {
        locker.lock();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == 0) {
                matrix[i][i] = threadN;
                System.out.println(threadName
                        + " изменил знаение в ячейке "
                        + i + " " + i);
                i++;
                break;
            }
        }
        locker.unlock();
    }

    /**
     * overriding methord of Object.
     * @param o o
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Matrix matrix1 = (Matrix) o;

        return Arrays.deepEquals(matrix, matrix1.matrix);

    }

    /**
     * hash code.
     * @return int value, object as number
     */
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    /**
     * overriding object method for show result.
     * @return String
     */
    @Override
    public String toString() {
        String s = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                s += matrix[i][j] + "\t";
            }
            s += "\n";
        }
        return "Matrix{"
                + "matrix=\n"
                + s
                + '}';
    }
}
