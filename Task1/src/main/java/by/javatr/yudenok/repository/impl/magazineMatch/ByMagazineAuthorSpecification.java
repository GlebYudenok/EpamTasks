package by.javatr.yudenok.repository.impl.magazineMatch;

import by.javatr.yudenok.bean.Author;
import by.javatr.yudenok.bean.Magazine;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.rmi.runtime.Log;

public class ByMagazineAuthorSpecification implements Specification<Magazine> {

    private Author searchAuthor;
    private static final Logger logger = LogManager.getLogger(ByMagazineAuthorSpecification.class);

    public ByMagazineAuthorSpecification(Author searchAuthor) throws SpecificatorException {
        if(searchAuthor == null || searchAuthor.getSurname() == null || searchAuthor.getName() == null){
            logger.error("No one of parameters cannot be null");
            System.err.println("Wrong parameter");
            throw new SpecificatorException();
        }else {
            this.searchAuthor = searchAuthor;
        }
    }

    public boolean match(Magazine bean) {
        return searchAuthor.equals(bean.getAuthor());
    }
}
