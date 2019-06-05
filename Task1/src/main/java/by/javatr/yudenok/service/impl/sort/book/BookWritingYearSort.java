package by.javatr.yudenok.service.impl.sort.book;


import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.service.SorterService;
import by.javatr.yudenok.service.impl.comparator.book.BookCopmaratorWritingYear;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookWritingYearSort implements SorterService {

    private static final Logger logger = LogManager.getLogger(BookWritingYearSort.class);

    @Override
    public void sort() {
        Library.getInstance().getBookList().sort(new BookCopmaratorWritingYear());
        logger.info("Books was sorted");
    }
}
