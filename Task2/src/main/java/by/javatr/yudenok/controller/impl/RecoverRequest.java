package by.javatr.yudenok.controller.impl;

import by.javatr.yudenok.controller.Command;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.ServiceException;
import by.javatr.yudenok.runner.Main;
import by.javatr.yudenok.service.RecoverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * RecoverRequest class call readNParse service and execute several task.
 */
public class RecoverRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger(RecoverRequest.class);

    /**
     * Perform function of calls next layers.
     * @param request
     * @throws IOException
     * @throws ParserException
     * @throws DAOException
     */
    @Override
    public void executeTask(final String request) throws IOException, ParserException, ServiceException {
        RecoverService recoverService = new RecoverService();
        recoverService.writeToFile("src\\main\\resources\\formattedFile");
        LOGGER.info("Information was recovered successfully!");
    }
}
