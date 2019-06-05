package by.javatr.yudenok.repository.impl.bookMatch;

import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByBookNameWordInTitleSpecification implements Specification<Book> {

    private static final Logger logger = LogManager.getLogger(ByBookNameWordInTitleSpecification.class);

    private String searchString;

    public ByBookNameWordInTitleSpecification(String title) throws SpecificatorException {
        if(title == null){
            logger.error("Invalid null specificator");
            System.err.println("Was getting null as parameter");
            throw new SpecificatorException();
        }else {
            this.searchString = title;
        }
    }

    @Override
    public boolean match(Book model) {
        return firstWordEqual(model.getTitle());
    }

    private boolean firstWordEqual(String title){
        return title.contains(searchString);
    }
}
