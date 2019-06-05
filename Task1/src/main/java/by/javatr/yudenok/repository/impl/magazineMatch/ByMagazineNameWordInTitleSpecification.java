package by.javatr.yudenok.repository.impl.magazineMatch;


import by.javatr.yudenok.bean.Magazine;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByMagazineNameWordInTitleSpecification implements Specification<Magazine> {

    private static final Logger logger = LogManager.getLogger(ByMagazineNameWordInTitleSpecification.class);

    private String searchString;

    public ByMagazineNameWordInTitleSpecification(String title) throws SpecificatorException {
        if(title == null){
            logger.error("Title cannot be null");
            System.err.println("Title cannot be null");
            throw new SpecificatorException();
        }
        else {
            this.searchString = title;
        }
    }

    @Override
    public boolean match(Magazine model) {
        return firstWordEqual(model.getTitle());
    }

    private boolean firstWordEqual(String title){

        logger.info("firstWordEqual function is called");

        if(title.contains(searchString))
            return true;
        else
            return false;
    }
}
