package by.javatr.yudenok.repository.impl.magazineMatch;

import by.javatr.yudenok.bean.Magazine;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByMagazineAmountOfPagesRangeSpecification implements Specification<Magazine> {

    private int to;
    private int from;

    private static final Logger logger = LogManager.getLogger(ByMagazineAmountOfPagesRangeSpecification.class);

    public ByMagazineAmountOfPagesRangeSpecification(int from, int to) throws SpecificatorException {
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
    public boolean match(Magazine model) {
        return inRange(model.getPagesAmount());
    }

    private boolean inRange(int x){

        logger.info("inRange function is called");

        if(x >= from && x <= to)
            return true;
        else
            return false;
    }
}
