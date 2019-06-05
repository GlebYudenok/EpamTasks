package by.javatr.yudenok.repository.impl.albumMatch;

import by.javatr.yudenok.bean.Album;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByAlbumAmoutOfPagesSpecification implements Specification<Album> {

    private int searchAmountOfPages;
    private static final Logger logger = LogManager.getLogger(ByAlbumAmoutOfPagesSpecification.class);

    public ByAlbumAmoutOfPagesSpecification(int searchAmountOfPages) throws SpecificatorException {

        if(searchAmountOfPages < 0){
            logger.error("Amount of pages cannot be less than 0");
            System.err.println("Amount of pages cannot be less than 0");
            throw new SpecificatorException();
        }else {
            this.searchAmountOfPages = searchAmountOfPages;
        }
    }

    public boolean match(Album model) {
        return model.getPagesAmount() == searchAmountOfPages;
    }
}
