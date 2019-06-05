package by.javatr.yudenok.repository.impl.albumMatch;

import by.javatr.yudenok.bean.Album;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByAlbumCompanysNameSpecification implements Specification<Album> {

    String searchCompanyName;

    private static final Logger logger = LogManager.getLogger(ByAlbumCompanysNameSpecification.class);

    public ByAlbumCompanysNameSpecification(String searchCompanyName) throws SpecificatorException {
        if(searchCompanyName == null){
            logger.error("Invalid null specificator");
            System.err.println("Was getting null as parameter");
            throw new SpecificatorException();
        }
        this.searchCompanyName = searchCompanyName;
    }

    public boolean match(Album model){
        return searchCompanyName.toLowerCase().equals(model.getProducerName().toLowerCase());
    }
}
