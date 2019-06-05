package by.javatr.yudenok.service;

import by.javatr.yudenok.bean.Paragraph;
import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.composite.LeafElement;
import by.javatr.yudenok.controller.parser.impl.ParagraphParser;
import by.javatr.yudenok.controller.parser.impl.SentenceParser;
import by.javatr.yudenok.controller.parser.impl.TextParser;
import by.javatr.yudenok.controller.parser.impl.WordParser;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;
import org.junit.Test;

import java.io.IOException;

public class SorterServiceTest {

    @Test
    public void sortParagraphs() throws IOException, ParserException, DAOException {
        ReadService rs = new ReadService();
        String s = rs.readNParse("src\\test\\resources\\File");

        TextParser parseText = new TextParser();
        ParagraphParser parseParagraph = new ParagraphParser();
        SentenceParser parseSentence = new SentenceParser();
        WordParser wp = new WordParser();

        parseText.setNext(parseParagraph);
        parseParagraph.setNext(parseSentence);
        parseSentence.setNext(wp);

        Text textSorted = parseText.parseLine(s);

        for (LeafElement leaf : textSorted.getTextElements()) {
            SorterService.sortParagraphsBySentences((Paragraph)leaf).print();
        }
    }
}