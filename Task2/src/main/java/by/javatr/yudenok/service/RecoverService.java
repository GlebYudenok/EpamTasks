package by.javatr.yudenok.service;

import by.javatr.yudenok.dao.TextDAOimpl;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.ServiceException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Recover data from object to any file.
 */
public final class RecoverService {

    private TextDAOimpl td = TextDAOimpl.getInstance();

    /**
     * Write text to file.
     * @param path path of file which by recover datas.
     * @return
     * @throws IOException ex
     * @throws ParserException ex
     * @throws ServiceException ex
     */
    public String writeToFile(final String path)
            throws IOException, ParserException, ServiceException {

        byte[] bytes = null;
        try {
            bytes = td.getText().getElement().getBytes();
        } catch (NullPointerException e) {
            throw new ServiceException("Error at the time of reading from file");
        }

        Files.write(Paths.get(path), bytes);
        return null;
    }
}
