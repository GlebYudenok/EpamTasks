package by.javatr.yudenok.controller.impl;

import by.javatr.yudenok.controller.Command;
import by.javatr.yudenok.controller.Controller;
import by.javatr.yudenok.exception.ControllerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class need for processing unknown commands.
 */
public class WrongRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Command.class);

    @Override
    public void executeTask(final String request) throws ControllerException {
        LOGGER.error("Wrong type of command");
        throw new ControllerException("Wrong type of command");
    }
}
