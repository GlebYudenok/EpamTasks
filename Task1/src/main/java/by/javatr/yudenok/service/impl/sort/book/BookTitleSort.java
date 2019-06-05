package by.javatr.yudenok.service.impl.sort.book;

import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.exception.ServiceException;
import by.javatr.yudenok.service.SorterService;
import by.javatr.yudenok.service.impl.comparator.book.BookTitleComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookTitleSort implements SorterService {

    private static final Logger logger = LogManager.getLogger(BookTitleSort.class);

    @Override
    public void sort() throws ServiceException {
        Library.getInstance().getBookList().sort(new BookTitleComparator());
        logger.info("Books was sorted");
    }
}
