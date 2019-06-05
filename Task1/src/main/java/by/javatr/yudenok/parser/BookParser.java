package by.javatr.yudenok.parser;

import by.javatr.yudenok.bean.Author;
import by.javatr.yudenok.bean.Book;
import by.javatr.yudenok.bean.BookGenre;
import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.service.FileLinesCounterService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class BookParser {

    private static final Logger logger = LogManager.getLogger(BookParser.class);

    public static List<Book> parse(File path) throws IOException, ParserException{

        Library.getInstance().getBookList().removeAll(Library.getInstance().getBookList());

        List<String> parserList = new ArrayList<>();

            parserList = fileRead(path);

        String []arr = new String[parserList.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = parserList.get(i);
        }

        for(int i = 0; i < arr.length; i++) {
            String[] s = arr[i].split(" ");

            try {
                Library.getInstance().getBookList().add(toLibrary(s));
            }catch (ParserException e){
                Library.getInstance().getBookList().removeAll(Library.getInstance().getBookList());
                logger.warn("Stop reading and parsing.");
                break;
            }

        }
        return Library.getInstance().getBookList();
    }

    private static List<String> fileRead(File filePath) throws IOException {

        RandomAccessFile file = new RandomAccessFile(filePath,"r");

        List<String> s = new ArrayList<String>();

        for(int i = 0; i < FileLinesCounterService.countLines(filePath.toString()); i++){
            s.add(file.readLine());
        }
        return s;
    }

    private static Book toLibrary(String []s) throws ParserException {

        Library library = Library.getInstance();

        String authorsName;
        String authorsSurname;
        String bookTitle;
        int pagesAmount;
        int year;
        BookGenre genre;

        authorsName = s[0].toString();
        authorsSurname = s[1].toString();
        bookTitle = s[2].toString();
        try {
            pagesAmount = Integer.parseInt(s[3]);
            year = Integer.parseInt(s[4]);
            genre = BookGenre.valueOf(s[5]);
        }catch (Exception e){
            logger.error("Wrong datas in file. Cannot parse.");
            throw new ParserException();
        }

        Author author = new Author(authorsSurname, authorsName);
        Book book = new Book(author,bookTitle,genre,year,pagesAmount);
        return book;
    }
}
