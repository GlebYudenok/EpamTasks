package by.javatr.yudenok.repository.impl.bookMatch;

import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByBookTitleSpecification implements Specification<Book> {

    private String searchString;
    private static final Logger logger = LogManager.getLogger(ByBookTitleSpecification.class);

    public ByBookTitleSpecification(String searchTitle) throws SpecificatorException {

        if(searchTitle == null){
            logger.error("Invalid null specificator");
            System.err.println("Was getting null as parameter");
            throw new SpecificatorException();
        }else {
            this.searchString = searchTitle;
        }
    }

    public boolean match(Book entity) {
        return entity.getTitle().equals(searchString);
    }
}
