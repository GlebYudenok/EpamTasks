package by.javatr.yudenok.repository.impl.bookMatch;

import by.javatr.yudenok.bean.Author;
import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByBookAuthorSpecification implements Specification<Book> {

    private Author searchAuthor;

    private static final Logger logger = LogManager.getLogger(ByBookAuthorSpecification.class);

    public ByBookAuthorSpecification(Author searchAuthor) throws SpecificatorException {
        if(searchAuthor == null || searchAuthor.getSurname() == null || searchAuthor.getName() == null){
            logger.error("Invalid null specificator");
            System.err.println("Was getting null as parameter");
            throw new SpecificatorException();
        }
        this.searchAuthor = searchAuthor;
    }

    public boolean match(Book model) {
        return searchAuthor.equals(model.getAuthor());
    }
}
