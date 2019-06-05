package by.javatr.yudenok.controller;

import by.javatr.yudenok.exception.ControllerException;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Application management class.
 */
public class Controller {

    private final CommandProvider commandProvider = new CommandProvider();
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);


    public void executeTask(final String request) throws IOException, ParserException, DAOException, ServiceException, ControllerException {

        Command command = null;
        String task;

        try {
            try {
                command = commandProvider.getCommand(request);
            } catch (ServiceException e) {
                LOGGER.error("The object contains nothing");
            }
        } catch (ControllerException e) {
            LOGGER.error("Wrong argument as command");
        }

        command.executeTask(request);
    }
}
