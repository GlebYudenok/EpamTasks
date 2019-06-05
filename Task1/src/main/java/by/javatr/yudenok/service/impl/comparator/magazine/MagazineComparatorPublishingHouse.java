package by.javatr.yudenok.service.impl.comparator.magazine;


import by.javatr.yudenok.bean.Magazine;

import java.util.Comparator;

public class MagazineComparatorPublishingHouse implements Comparator<Magazine> {
    @Override
    public int compare(Magazine o1, Magazine o2) {
        return o1.getPublishingHouseName().compareTo(o2.getPublishingHouseName());
    }
}
