package by.javatr.yudenok.controller.impl;

import by.javatr.yudenok.bean.Paragraph;
import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.composite.LeafElement;
import by.javatr.yudenok.controller.Command;
import by.javatr.yudenok.controller.parser.impl.ParagraphParser;
import by.javatr.yudenok.controller.parser.impl.SentenceParser;
import by.javatr.yudenok.controller.parser.impl.TextParser;
import by.javatr.yudenok.controller.parser.impl.WordParser;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.service.ReadService;
import by.javatr.yudenok.service.SorterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

    /**
     * SortRequest class call sort service and execute function of services.
     */
public class SortRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger(SortRequest.class);
    private final ReadService readService = new ReadService();

    /**
     * Perform function of calls next layers.
     * @param request
     * @throws IOException
     * @throws ParserException
     * @throws DAOException
     */
    @Override
    public void executeTask(final String request) throws IOException, ParserException, DAOException {
        String s = readService.readNParse("src\\main\\resources\\File");

        TextParser tp = new TextParser();
        ParagraphParser parseParagraph = new ParagraphParser();
        SentenceParser parseSentence = new SentenceParser();
        WordParser wp = new WordParser();
        tp.setNext(parseParagraph);
        parseParagraph.setNext(parseSentence);
        parseSentence.setNext(wp);

        Text t = tp.parseLine(s);

        for (LeafElement element : t.getTextElements()) {
            SorterService.sortParagraphsBySentences((Paragraph) element).print();
        }

        LOGGER.info("Sorting completed successfully!");
    }
}
