package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.Sentence;
import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.bean.Word;
import by.javatr.yudenok.composite.LeafElement;
import by.javatr.yudenok.exception.ParserException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParagraphParserTest {

    @Test
    public void parseParagraph() throws ParserException {
        String paragraphTest = " \tIt has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution of letters, as opposed to using 'Content here, content\n" +
                "here', making it look like readable English.\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its\n" +
                "layout.\n" +
                "\tBye.";

        TextParser parseText = new TextParser();
        ParagraphParser parseParagraph = new ParagraphParser();
        SentenceParser parseSentence = new SentenceParser();
        WordParser wp = new WordParser();

        parseText.setNext(parseParagraph);
        parseParagraph.setNext(parseSentence);
        parseSentence.setNext(wp);

        Text text = parseText.parseLine(paragraphTest);
        text.print();
    }

    @Test(expected = ParserException.class)
    public void parseNull() throws ParserException {
        String s = null;

        TextParser parseText = new TextParser();
        ParagraphParser parseParagraph = new ParagraphParser();
        SentenceParser parseSentence = new SentenceParser();
        WordParser wp = new WordParser();

        parseText.setNext(parseParagraph);
        parseParagraph.setNext(parseSentence);
        parseSentence.setNext(wp);

        Text text = parseText.parseLine(s);
        text.print();
    }
}