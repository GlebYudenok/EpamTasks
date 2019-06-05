package by.javatr.yudenok.service.impl.comparator.album;

import by.javatr.yudenok.bean.Album;

import java.util.Comparator;

public class AlbumComparatorCompanysName implements Comparator<Album> {
    @Override
    public int compare(Album o1, Album o2) {
        return o1.getProducerName().compareTo(o2.getProducerName());
    }
}
