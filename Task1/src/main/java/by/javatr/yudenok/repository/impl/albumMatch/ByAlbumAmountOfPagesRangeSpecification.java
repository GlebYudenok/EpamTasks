package by.javatr.yudenok.repository.impl.albumMatch;


import by.javatr.yudenok.bean.Album;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByAlbumAmountOfPagesRangeSpecification implements Specification<Album> {

    private static final Logger logger = LogManager.getLogger(ByAlbumAmountOfPagesRangeSpecification.class);

    private int to;
    private int from;

    public ByAlbumAmountOfPagesRangeSpecification(int from, int to) throws SpecificatorException {
        if(from < 0 || to < 1 || from > to){
            logger.error("Wrong parameter");
            System.err.println("Wrong parameter");
            throw new SpecificatorException();
        }else {
            this.to = to;
            this.from = from;
        }
    }

    @Override
    public boolean match(Album model){
        return inRange(model.getPagesAmount());
    }

    private boolean inRange(int x){

        if(x >= from && x <= to) {
            return true;
        }
        else
            return false;
    }
}
