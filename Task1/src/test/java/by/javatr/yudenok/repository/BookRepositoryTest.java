package by.javatr.yudenok.repository;
import by.javatr.yudenok.bean.Author;
import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.bean.BookGenre;
import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.RepositoryException;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.parser.BookParser;
import by.javatr.yudenok.repository.impl.BookRepository;
import by.javatr.yudenok.repository.impl.bookMatch.ByBookSpecification;
import by.javatr.yudenok.repository.impl.bookMatch.ByBookTitleSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class BookRepositoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    static List<Book> bookList = new ArrayList<>();

    @Before
    public void setUp() {
        bookList.add(new Book(new Author("firstname", "secondname"),
                "Mumu", BookGenre.HORROR, 2015, 253));
        Library.getInstance().setBookList(bookList);
    }

    @AfterEach
    void clear() {
        Library.getInstance().getBookList().removeAll(Library.getInstance().getBookList());
    }

    @Test
    public void correctOneTitleFind() throws SpecificatorException, RepositoryException {
        Repository<Book> bookRepository = new BookRepository();
        List<Book> res = new ArrayList<>();
        res = bookRepository.find(new ByBookTitleSpecification("Mumu"));

        assertEquals(1, res.size());
    }

    @Test(expected = SpecificatorException.class)
    public void nullAsParameter() throws SpecificatorException, RepositoryException {
        Repository<Book> bookRepository = new BookRepository();
        List<Book> res = new ArrayList<>();
        res = bookRepository.find(new ByBookTitleSpecification(null));
    }

    @Test(expected = SpecificatorException.class)
    public void wrongParameter() throws SpecificatorException, RepositoryException {
        Repository<Book> bookRepository = new BookRepository();
        List<Book> res = new ArrayList<>();
        res = bookRepository.find(new ByBookSpecification(new Book(new Author("1","2"),"title",BookGenre.HORROR
        ,-324,-2)));
    }

    @Test(expected = IOException.class)
    public void readWithNoExsitingFile() throws IOException, ParserException {
        BookParser.parse(new File("C:\fsdf"));;
    }


    @Test
    public void readWithValidDatasInFile() throws IOException, ParserException {
        List<Book> bookList = new ArrayList<>();
        bookList = BookParser.parse(new File("src\\test\\java\\by\\javatr\\yudenok\\resources\\BookList.txt"));

        int expectedLinesInFile = 7;

        assertEquals(expectedLinesInFile, bookList.size());
    }
}
