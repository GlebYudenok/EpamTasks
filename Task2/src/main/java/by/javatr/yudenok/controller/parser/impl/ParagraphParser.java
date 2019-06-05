package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.Paragraph;
import by.javatr.yudenok.bean.Sentence;
import by.javatr.yudenok.composite.LeafElement;
import by.javatr.yudenok.controller.parser.ElementParser;
import by.javatr.yudenok.exception.ParserException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParagraphParser extends ElementParser<LeafElement> {

    private static final Pattern SENTENCE_DELIMETER = Pattern.compile("[.!?]\r?");

    /**
     * Parse text on paragraphs.
     * @param line
     * @return paragraph - part of text
     * @throws ParserException
     */
    @Override
    public LeafElement parseLine(final String line) throws ParserException {

        if (line == null || line.isEmpty()) {
            throw new ParserException("Input string is empty");
        }

        List<LeafElement> sentenceList = new ArrayList<>();
        String[] strings = line.trim().split(SENTENCE_DELIMETER.pattern());

        for (int j = 0; j < strings.length; j++) {
            LeafElement leaf = nextParse(strings[j]);

            Sentence sentence = (Sentence) leaf;
            sentenceList.add(sentence);
        }
        Paragraph paragraph = new Paragraph(sentenceList);

        return paragraph;
    }
}
