package by.javatr.yudenok.dao;

import by.javatr.yudenok.bean.Matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class DAO {

    /**
     * singletone instance.
     */
    private static DAO INSTANCE = null;
    /**
     * max size of array.
     */
    private static final int MAX_ARRAY_SIZE = 124;

    /**
     * private constructor for can't create object.
     */
    private DAO() {

    }

    /**
     * singletone implementation.
     * @return DAO object
     */
    public static DAO getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (DAO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DAO();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    protected Object clone() {
        return INSTANCE;
    }

    /**
     * read data from file to matrix.
     * @param path path of file.
     * @throws IOException exception with file
     */
    public void read(final String path) throws IOException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);

        int k = 0;
        String s;
        while (k < matrix.getMatrix().length) {
            s = bf.readLine();
            String[] nums = s.split(" ");
            for (int i = 0; i < matrix.getMatrix().length; i++) {
                matrix.getMatrix()[k][i] = Integer.valueOf(nums[i]);
                if (i == k) {
                    matrix.getMatrix()[k][i] = 0;
                }
            }
            k++;
        }
    }

    /**
     * create Matrix object.
     */
    public Matrix matrix = Matrix.getInstance();
}
