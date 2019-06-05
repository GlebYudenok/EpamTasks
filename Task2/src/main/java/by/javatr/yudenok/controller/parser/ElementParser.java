package by.javatr.yudenok.controller.parser;

import by.javatr.yudenok.exception.ParserException;

/**
 * Abstract class which create chain of responsibility.
 * @param <T>
 */
public abstract class ElementParser<T> implements ParserChain {

    /**
     * Reference to next element of chain.
     */
    private ParserChain<T> next;

    /**
     *
     * @param next
     */

    /**
     * Link with next element of chain.
     * @param next - reference to next element of chain
     */
    public void setNext(final ParserChain<T> next) {
        this.next = next;
    }

    /**
     * Parse next element of chain.
     * @param line - line, which should parse.
     * @return
     * @throws ParserException parser exception
     */
    public T nextParse(final String line) throws ParserException {
        if (next != null) {
            return next.parseLine(line);
        } else {
            return null;
        }
    }
}
