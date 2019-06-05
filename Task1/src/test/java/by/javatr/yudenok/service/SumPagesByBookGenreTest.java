package by.javatr.yudenok.service;

import by.javatr.yudenok.bean.Author;
import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.bean.BookGenre;
import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.exception.ServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumPagesByBookGenreTest {

    public static List<Book> bookList = new ArrayList<>();

    @Before
    public void set(){
        bookList.add(new Book(new Author("firstname", "secondname"),
                "Mumu", BookGenre.NONFICTION, 2015, 253));
        bookList.add(new Book(new Author("firstname1", "secondname1"),
                "Mumu1", BookGenre.NONFICTION, 2015, 600));
        bookList.add(new Book(new Author("firstname2", "secondname2"),
                "Mumu2", BookGenre.HORROR, 2015, 253));
        Library.getInstance().setBookList(bookList);
    }

    @Test(expected = ServiceException.class)
    public void sumOfPagesWithNullGenre() throws ServiceException {
        SumPagesByBookGenre.calculate(null);
    }

    @Test
    public void sumOfPagesWithCorrectGenre() throws ServiceException {
        int actual = SumPagesByBookGenre.calculate(BookGenre.NONFICTION);
        int expected = 853;
        assertEquals(expected,actual);
    }
}
