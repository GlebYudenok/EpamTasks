package by.javatr.yudenok.controller.parser;

import by.javatr.yudenok.exception.ParserException;

/**
 * Interface which implements to Parser of elements, component of chain.
 * @param <T>
 */
public interface ParserChain<T> {
    /**
     * @param line arg
     * @return
     * @throws ParserException simple ex
     */
    T parseLine(String line) throws ParserException;
}
