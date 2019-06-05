package by.javatr.yudenok.repository.impl;

import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.RepositoryException;
import by.javatr.yudenok.parser.BookParser;
import by.javatr.yudenok.repository.Repository;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookRepository implements Repository<Book> {

    private static final File filePath = new File("src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "BookList.txt");


    public File getPath() {
        return filePath;
    }

    private static final Logger logger = LogManager.getLogger(BookRepository.class);

    public void read() throws IOException, ParserException {
            BookParser.parse(getPath());
    }

    public void update() throws IOException {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(getPath());
        }catch (IOException e){
            throw new IOException();
        }

        for(Book book : Library.getInstance().getBookList()){
            fileWriter.write(book.getAuthor().getName() + " ");
            fileWriter.write(book.getAuthor().getSurname() + " ");
            fileWriter.write(book.getTitle() + " ");
            fileWriter.write(book.getPagesAmount() + " ");
            fileWriter.write(book.getWrittingYear() + " ");
            fileWriter.write(book.getGenre() + "\n");
        }

        fileWriter.close();
    }

    @Override
    public void remove(Book entity) throws RepositoryException {
        checkNull(entity);

        Library.getInstance().getBookList().remove(entity);
    }

    public List<Book> find(Specification specification) throws RepositoryException {

        checkNull(specification);

        List<Book> result = new ArrayList<Book>();

            for (int i = 0; i < Library.getInstance().getBookList().size(); i++) {
                if (specification.match(Library.getInstance().getBookList().get(i))) {
                    result.add(Library.getInstance().getBookList().get(i));
                }
            }
        return result;
    }

    @Override
    public void removeAll(Specification specification) throws RepositoryException {

        checkNull(specification);

        for(int i = 0; i < Library.getInstance().getBookList().size(); i++){
            if(specification.match(Library.getInstance().getBookList().get(i))){
                Library.getInstance().getBookList().remove(i);
                i--;
            }
        }
    }

    @Override
    public void add(Book entity) throws RepositoryException {

        checkYear(entity);
        checkNull(entity);

        Library.getInstance().getBookList().add(entity);
    }

    private static void checkNull (Object obj) throws RepositoryException {

        if (obj == null) {
            logger.error("Was get null as parameter");
            throw new RepositoryException();
        }
    }

    private static void checkYear (Book obj) throws RepositoryException{
        Calendar c = Calendar.getInstance();
        if(obj.getWrittingYear() > c.get(Calendar.YEAR)) {
            logger.error("Year more than current");
            throw new RepositoryException();
        }
    }
}
