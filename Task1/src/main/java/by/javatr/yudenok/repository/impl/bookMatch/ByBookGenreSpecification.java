package by.javatr.yudenok.repository.impl.bookMatch;


import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.bean.BookGenre;
import by.javatr.yudenok.repository.Specification;

public class ByBookGenreSpecification implements Specification<Book> {

    private BookGenre searchGenre;

    public ByBookGenreSpecification(BookGenre searchGenre){
        this.searchGenre = searchGenre;
    }

    public boolean match(Book model) {
        return searchGenre == model.getGenre();
    }
}
