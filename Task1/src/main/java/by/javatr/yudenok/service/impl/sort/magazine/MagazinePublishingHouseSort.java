package by.javatr.yudenok.service.impl.sort.magazine;


import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.service.SorterService;
import by.javatr.yudenok.service.impl.comparator.magazine.MagazineComparatorPublishingHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MagazinePublishingHouseSort implements SorterService {

    private static final Logger logger = LogManager.getLogger(MagazinePublishingHouseSort.class);

    @Override
    public void sort()
    {
        Library.getInstance().getMagazineList().sort(new MagazineComparatorPublishingHouse());
        logger.info("Magazines was sorted");
    }
}
