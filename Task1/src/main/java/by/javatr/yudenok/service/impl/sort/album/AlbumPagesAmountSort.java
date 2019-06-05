package by.javatr.yudenok.service.impl.sort.album;


import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.service.SorterService;
import by.javatr.yudenok.service.impl.comparator.album.AlbumComparatorPagesAmount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlbumPagesAmountSort implements SorterService {

    private static final Logger logger = LogManager.getLogger(AlbumPagesAmountSort.class);

    @Override
    public void sort(){
       Library.getInstance().getAlbumList().sort(new AlbumComparatorPagesAmount());
       logger.info("Albums was sorted");
    }
}
