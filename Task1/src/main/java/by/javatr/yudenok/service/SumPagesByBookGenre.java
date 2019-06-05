package by.javatr.yudenok.service;

import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.bean.BookGenre;
import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumPagesByBookGenre {

    private static final Logger logger = LogManager.getLogger(SumPagesByBookGenre.class);

    public static int calculate(BookGenre g) throws ServiceException {

        checkNull(g);

        int sum = 0;

        for (Book book : Library.getInstance().getBookList()){
            if(book.getGenre() == g){
                sum += book.getPagesAmount();
            }
        }

        return sum;
    }

    private static void checkNull (Object obj) throws ServiceException{

        if (obj == null) {
            logger.error("Was get null as parameter");
            throw new ServiceException();
        }
    }
}
