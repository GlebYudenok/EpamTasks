package by.javatr.yudenok.service;

import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.controller.parser.impl.ParagraphParser;
import by.javatr.yudenok.controller.parser.impl.SentenceParser;
import by.javatr.yudenok.controller.parser.impl.TextParser;
import by.javatr.yudenok.controller.parser.impl.WordParser;
import by.javatr.yudenok.dao.TextDAOimpl;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;

import java.io.IOException;

public class ReadService {

    private TextDAOimpl textDAO = TextDAOimpl.getInstance();

    /**
     * Take obj from DAO reader and parse to elements.
     * @param path path of file
     * @return
     * @throws IOException ex
     * @throws ParserException ex
     * @throws DAOException ex
     */
    public String readNParse(final String path) throws IOException,
            ParserException, DAOException {

        String s = null;
        s = textDAO.read(path);

        TextParser parseText = new TextParser();
        ParagraphParser parseParagraph = new ParagraphParser();
        SentenceParser parseSentence = new SentenceParser();
        WordParser wp = new WordParser();

        parseText.setNext(parseParagraph);
        parseParagraph.setNext(parseSentence);
        parseSentence.setNext(wp);

        Text text = parseText.parseLine(s);
        textDAO.save(text);

        return s;
    }
}
