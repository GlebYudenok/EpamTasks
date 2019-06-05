package by.javatr.yudenok.repository.impl.bookMatch;

import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

public class ByBookSpecification implements Specification<Book> {

    private Book searchBook;

    private static final Logger logger = LogManager.getLogger(ByBookSpecification.class);

    public ByBookSpecification(Book searchBook) throws SpecificatorException {
        Calendar c = Calendar.getInstance();

        if(searchBook == null || searchBook.getAuthor() == null ||
                searchBook.getAuthor().getName() == null ||
                searchBook.getAuthor().getSurname() == null ||
                searchBook.getPagesAmount() < 0 ||
                searchBook.getWrittingYear() > c.get(Calendar.YEAR) || searchBook.getTitle() == null)
        {
            logger.error("One of argument is wrong");
            System.err.println("Wrong on of parameters");
            throw new SpecificatorException();
        }
        else {
            this.searchBook = searchBook;
        }
    }

    public boolean match(Book bean) {
        return bean.equals(searchBook);
    }
}
