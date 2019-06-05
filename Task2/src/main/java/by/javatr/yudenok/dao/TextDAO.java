package by.javatr.yudenok.dao;

import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.exception.DAOException;

import java.io.IOException;

/**
 * Describe simple data access layer.
 */
public interface TextDAO {
    /**
     * save from dao to some container.
     * @param text text
     */
    void save(Text text);

    /**
     * readNParse from dao to some container.
     * @param path - file path
     * @throws IOException ex
     * @throws DAOException ex
     */
    String read(String path) throws IOException, DAOException;
}
