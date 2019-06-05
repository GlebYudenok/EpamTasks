package by.javatr.yudenok.controller;

import by.javatr.yudenok.exception.ControllerException;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.ServiceException;

import java.io.IOException;

/**
 * Interface for implementation of pattern "command".
 */
public interface Command {

    /**
     * This function get request and with value dependency run several function.
     * @param request request from user
     * @throws IOException for files
     * @throws ParserException for parsers
     * @throws DAOException for readers, writers
     * @throws ServiceException for business logic
     * @throws ControllerException for controllers
     */
    void executeTask(String request) throws IOException,
            ParserException, DAOException, ServiceException, ControllerException;
}
