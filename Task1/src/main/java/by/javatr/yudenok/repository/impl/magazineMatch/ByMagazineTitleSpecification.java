package by.javatr.yudenok.repository.impl.magazineMatch;

import by.javatr.yudenok.bean.Magazine;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByMagazineTitleSpecification implements Specification<Magazine> {
    private String searchName;
    private static final Logger logger = LogManager.getLogger(ByMagazineNameWordInTitleSpecification.class);

    public ByMagazineTitleSpecification(String searchName) throws SpecificatorException {
        if(searchName == null) {
            logger.error("Publising house name cannot be null");
            System.err.println("Publishing house name cannot be null");
            throw new SpecificatorException();
        }else {
            this.searchName = searchName;
        }
    }

    public boolean match(Magazine bean) {
        return bean.getTitle().toLowerCase().equals(searchName.toLowerCase());
    }
}
