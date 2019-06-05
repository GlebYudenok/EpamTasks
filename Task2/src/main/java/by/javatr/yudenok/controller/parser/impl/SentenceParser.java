package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.Sentence;
import by.javatr.yudenok.composite.LeafElement;
import by.javatr.yudenok.controller.parser.ElementParser;
import by.javatr.yudenok.controller.parser.ParserChain;
import by.javatr.yudenok.exception.ParserException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SentenceParser extends ElementParser {

    private static final Pattern WORDS_DELIMETER = Pattern.compile("\\s");

    /**
     * Parse paragraphs on sentences.
     * @param line
     * @return sentence - part of text
     * @throws ParserException
     */
    @Override
    public LeafElement parseLine(final String line) throws ParserException {
        if (line == null || line.isEmpty()) {
            throw new ParserException("Input string is empty");
        }

        List<LeafElement> wordList = new ArrayList<>();
        String[] strings = line.trim().split(WORDS_DELIMETER.pattern());

        for (String s : strings) {
            LeafElement leaf = (LeafElement) nextParse(s);

            wordList.add(leaf);
        }

        Sentence sentence = new Sentence(wordList);
        return sentence;
    }
}
