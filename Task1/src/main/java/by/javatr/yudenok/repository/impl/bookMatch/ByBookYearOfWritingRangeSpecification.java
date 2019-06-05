package by.javatr.yudenok.repository.impl.bookMatch;

import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

public class ByBookYearOfWritingRangeSpecification implements Specification<Book> {

    private static final Logger logger = LogManager.getLogger(ByBookYearOfWritingRangeSpecification.class);

    private int from;
    private int to;

    public ByBookYearOfWritingRangeSpecification(int from, int to) throws SpecificatorException {
        Calendar c = Calendar.getInstance();
        if(from > c.get(Calendar.YEAR) || to > c.get(Calendar.YEAR) || to < from) {
            logger.error("Wrong argument");
            System.err.println("Wrong argument");
            throw new SpecificatorException();
        }
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean match(Book model) {
        return inRange(model.getWrittingYear());
    }

    private boolean inRange(int x){

        if(x >= from && x <= to)
            return true;
        else
            return false;
    }
}
