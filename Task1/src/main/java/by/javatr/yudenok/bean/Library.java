package by.javatr.yudenok.bean;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private static Library instance;

    private List<Album> albumList = new ArrayList<Album>();
    private List<Book> bookList = new ArrayList<Book>();
    private List<Magazine> magazineList = new ArrayList<Magazine>();

    private Library(){}

    public static Library getInstance(){
        if(instance == null){
            instance = new Library();
        }
        return instance;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Magazine> getMagazineList() {
        return magazineList;
    }

    public void setMagazineList(List<Magazine> magazineList) {
        this.magazineList = magazineList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (albumList != null ? !albumList.equals(library.albumList) : library.albumList != null) return false;
        if (bookList != null ? !bookList.equals(library.bookList) : library.bookList != null) return false;
        return magazineList != null ? magazineList.equals(library.magazineList) : library.magazineList == null;

    }

    @Override
    public int hashCode() {
        int result = albumList != null ? albumList.hashCode() : 0;
        result = 31 * result + (bookList != null ? bookList.hashCode() : 0);
        result = 31 * result + (magazineList != null ? magazineList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Library : \n" +
                albumList +
                bookList +
                magazineList + '\n';
    }
}
