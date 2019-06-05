package by.javatr.yudenok.controller;

import by.javatr.yudenok.controller.impl.ReadRequest;
import by.javatr.yudenok.controller.impl.RecoverRequest;
import by.javatr.yudenok.controller.impl.SortRequest;
import by.javatr.yudenok.controller.impl.WrongRequest;
import by.javatr.yudenok.exception.ControllerException;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Convenient access to command instance.
 */
public class CommandProvider {

    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    private final Map<CommandName, Command> repository = new HashMap<>();

    enum CommandName {
        READ,
        RECOVER,
        SORT,
        WRONG_REQUEST
    }

    /**
     * Default constructor which do put into hash map keys and values.
     */
    public CommandProvider() {
        repository.put(CommandName.READ, new ReadRequest());
        repository.put(CommandName.SORT, new SortRequest());
        repository.put(CommandName.RECOVER, new RecoverRequest());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    /**
     * call commands depending on the request.
     * @param name command name
     * @return
     * @throws ControllerException ex
     * @throws IOException ex
     * @throws ParserException ex
     * @throws DAOException ex
     * @throws ServiceException ex
     */
    public Command getCommand(final String name) throws ControllerException,
            IOException, ParserException, DAOException, ServiceException {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ControllerException();
        }

            if (!repository.containsKey(commandName)) {
                command = repository.get(CommandName.WRONG_REQUEST);
                LOGGER.error("Wrong argument as command");
                throw new ControllerException();
            }

            command = repository.get(commandName);
            //command.executeTask(name);
        return command;
    }

}
