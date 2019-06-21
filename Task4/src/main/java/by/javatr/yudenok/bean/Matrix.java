package by.javatr.yudenok.bean;

import java.util.Arrays;

public class Matrix {
    private int [][]matrix;

    public Matrix(){
        matrix = new int[8][8];
    }

    public Matrix(int rows, int columns){
        matrix = new int[rows][columns];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        return Arrays.deepEquals(matrix, matrix1.matrix);

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        String s = new String();
        int a;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                s += matrix[i][j] + "\t";
            }
            s+="\n";
        }
        return "Matrix{" +
                "matrix=\n" + s +
                '}';
    }
}
