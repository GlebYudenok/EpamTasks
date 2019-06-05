package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.Word;
import by.javatr.yudenok.composite.LeafElement;
import by.javatr.yudenok.controller.parser.ParserChain;
import by.javatr.yudenok.exception.ParserException;

public class WordParser implements ParserChain<LeafElement> {

    /**
     * Adding word to container.
     * @param line
     * @return
     * @throws ParserException
     */
    @Override
    public LeafElement parseLine(final String line) throws ParserException {

        Word word = new Word(line);
        return word;
    }

}
