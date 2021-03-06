package by.javatr.yudenok.service.impl.comparator.book;


import by.javatr.yudenok.bean.Book;

import java.util.Comparator;

public class BookComparatorPagesAmount implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPagesAmount() - o2.getPagesAmount();
    }
}
