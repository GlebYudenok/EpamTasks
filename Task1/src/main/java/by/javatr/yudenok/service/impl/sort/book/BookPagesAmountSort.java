package by.javatr.yudenok.service.impl.sort.book;

import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.service.SorterService;
import by.javatr.yudenok.service.impl.comparator.book.BookComparatorPagesAmount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookPagesAmountSort implements SorterService {

    private static final Logger logger = LogManager.getLogger(BookPagesAmountSort.class);

    @Override
    public void sort() {
        Library.getInstance().getBookList().sort(new BookComparatorPagesAmount());
        logger.info("Books was sorted");
    }
}
