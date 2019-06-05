package by.javatr.yudenok.controller.impl;

import by.javatr.yudenok.controller.Command;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.service.ReadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * ReadRequest class call readNParse service and execute several task.
 */
public class ReadRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger(ReadRequest.class);
    private final ReadService readService = new ReadService();

    /**
     * Perform function of print and calls next layers.
     * @param request
     * @throws IOException
     * @throws ParserException
     * @throws DAOException
     */
    @Override
    public void executeTask(final String request) throws IOException, ParserException, DAOException {
        System.out.println(readService.readNParse("src\\main\\resources\\File"));
        LOGGER.info("Information was readNParse successfully!");
    }
}
