package by.javatr.yudenok.service.impl.sort.book;


import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.service.SorterService;
import by.javatr.yudenok.service.impl.comparator.book.BookComparatorAuthorsSurname;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookAuthorsSort implements SorterService {

    private static final Logger logger = LogManager.getLogger(BookAuthorsSort.class);

    @Override
    public void sort() {
        Library.getInstance().getBookList().sort(new BookComparatorAuthorsSurname());
        logger.info("Books was sorted");
    }
}
