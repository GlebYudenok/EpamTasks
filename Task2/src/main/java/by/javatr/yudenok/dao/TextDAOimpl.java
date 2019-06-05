package by.javatr.yudenok.dao;

import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.controller.parser.impl.ParagraphParser;
import by.javatr.yudenok.controller.parser.impl.SentenceParser;
import by.javatr.yudenok.controller.parser.impl.TextParser;
import by.javatr.yudenok.controller.parser.impl.WordParser;
import by.javatr.yudenok.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Implementation of DAO pattern.
 */
public class TextDAOimpl implements TextDAO {

    private static final Logger LOGGER = LogManager.getLogger(TextDAOimpl.class);
    private static final TextDAOimpl INSTANCE = new TextDAOimpl();
    private Text text = new Text();

    /**
     * Default empty constructor.
     */
    private TextDAOimpl() {

    }

    /**
     * Singletone object.
     * @return instance
     */
    public static TextDAOimpl getInstance() {
        return INSTANCE;
    }

    /**
     * getter for text object.
     * @return text object
     */
    public Text getText() {
        return text;
    }

    /**
     * save datas to object container.
     * @param text parameter
     */
    @Override
    public void save(final Text text) {
        this.text = text;
        LOGGER.info("Information saved!");
    }

    /**
     * readNParse datas from file to object container.
     * @param path
     * @return
     * @throws IOException
     */
    @Override
    public String read(final String path) throws IOException, DAOException {

        String parsedString = null;
        byte[] bytesString = null;

        try {
            bytesString = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            LOGGER.error("Error at the time of reading from file");
            throw new DAOException("Error at the time of reading from file");
        }
        parsedString = new String(bytesString);

        TextParser parseText = new TextParser();
        ParagraphParser parseParagraph = new ParagraphParser();
        SentenceParser parseSentence = new SentenceParser();
        WordParser wp = new WordParser();

        parseText.setNext(parseParagraph);
        parseParagraph.setNext(parseSentence);
        parseSentence.setNext(wp);

        return parsedString;
    }
}
