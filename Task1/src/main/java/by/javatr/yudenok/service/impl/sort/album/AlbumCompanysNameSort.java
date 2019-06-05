package by.javatr.yudenok.service.impl.sort.album;

import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.service.SorterService;
import by.javatr.yudenok.service.impl.comparator.album.AlbumComparatorCompanysName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlbumCompanysNameSort implements SorterService {

    private static final Logger logger = LogManager.getLogger(AlbumCompanysNameSort.class);

    @Override
    public void sort(){
        Library.getInstance().getAlbumList().sort(new AlbumComparatorCompanysName());
        logger.info("Albums was sorted");
    }
}
