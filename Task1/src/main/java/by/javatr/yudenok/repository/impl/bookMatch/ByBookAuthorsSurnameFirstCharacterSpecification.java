package by.javatr.yudenok.repository.impl.bookMatch;

import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByBookAuthorsSurnameFirstCharacterSpecification implements Specification<Book> {

    private static final Logger logger = LogManager.getLogger(ByBookAuthorsSurnameFirstCharacterSpecification.class);

    private char searchCharacter;

    public ByBookAuthorsSurnameFirstCharacterSpecification(char searchCharacter){
        this.searchCharacter = searchCharacter;
    }

    @Override
    public boolean match(Book model) {
        return firstCharEqual(model.getAuthor().getSurname());
    }

    private boolean firstCharEqual(String s){

        if(s.charAt(0) == searchCharacter)
            return true;
        else
            return false;
    }
}
