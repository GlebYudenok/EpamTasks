package by.javatr.yudenok.service;

import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.controller.parser.impl.ParagraphParser;
import by.javatr.yudenok.controller.parser.impl.SentenceParser;
import by.javatr.yudenok.controller.parser.impl.TextParser;
import by.javatr.yudenok.controller.parser.impl.WordParser;
import by.javatr.yudenok.dao.TextDAO;
import by.javatr.yudenok.dao.TextDAOimpl;
import by.javatr.yudenok.exception.DAOException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ReadServiceTest {

    @Test
    public void read() throws IOException, DAOException {

        TextDAO td = TextDAOimpl.getInstance();
        String actual = td.read("src\\test\\resources\\File");

        String expected = "    It has survived not only five centuries, but also the leap into electronic\r\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\r\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\r\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n" +
                "    It is a long established fact that a reader will be distracted by the readable\r\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\r\n" +
                "more-or-less normal distribution of letters, as opposed to using 'Content here, content\r\n" +
                "here', making it look like readable English.\r\n" +
                "    It is a established fact that a reader will be of a page when looking at its\r\n" +
                "layout.\r\n" +
                "    Can this parser parse words like can't or won't? We will find out!\r\n" +
                "    Bye.";

        assertEquals("mes", expected, actual);
    }

}