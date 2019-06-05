package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.composite.LeafElement;
import by.javatr.yudenok.controller.parser.ElementParser;
import by.javatr.yudenok.exception.ParserException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TextParser extends ElementParser {

    private static final Pattern PARAGRAPH_DELIMETER = Pattern.compile("\n(\\s{4,}|\t)");

    @Override
    public Text parseLine(final String line) throws ParserException {
        if (line == null || line.isEmpty()) {
            throw new ParserException("Input string is empty");
        }

        List<LeafElement> paragraphList = new ArrayList<>();

        String[] strings = line.trim().split(PARAGRAPH_DELIMETER.pattern());

        for (String s : strings) {
            LeafElement leaf = (LeafElement) nextParse(s);
            paragraphList.add(leaf);
        }

        Text text = new Text(paragraphList);

        return text;
    }
}
