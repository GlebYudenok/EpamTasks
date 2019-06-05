package by.javatr.yudenok.parser;

import by.javatr.yudenok.bean.Author;
import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.bean.Magazine;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.service.FileLinesCounterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class MagazineParser {

    private static final Logger logger = LogManager.getLogger(MagazineParser.class);

    public static List<Magazine> parse(File path) throws IOException, ParserException {

        Library.getInstance().getMagazineList().removeAll(Library.getInstance().getMagazineList());

        List<String> parserList = new ArrayList<>();

        parserList = fileRead(path);

        String []arr = new String[parserList.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = parserList.get(i);
        }

        for(int i = 0; i < arr.length; i++) {
            String[] s = arr[i].split(" ");

            try {
                Library.getInstance().getMagazineList().add(toLibrary(s));
            } catch (ParserException e) {
                Library.getInstance().getMagazineList().removeAll(Library.getInstance().getMagazineList());
                logger.warn("Stop reading and parsing.");
                break;
            }

        }
        return Library.getInstance().getMagazineList();
    }

    private static List<String> fileRead(File filePath) throws IOException {

        RandomAccessFile file = new RandomAccessFile(filePath,"r");

        List<String> s = new ArrayList<String>();

        for(int i = 0; i < FileLinesCounterService.countLines(filePath.toString()); i++){
            s.add(file.readLine());
        }
        return s;
    }

    private static Magazine toLibrary(String []s) throws ParserException {

        Library library = Library.getInstance();

        int pagesAmount;
        String publishingHouse;
        String title;
        Author author;
        try {
            author = new Author(s[0], s[1]);
            title = s[2];
            publishingHouse = s[3];
            pagesAmount = Integer.parseInt(s[4]);
        }catch (Exception e){
            logger.error("Wrong datas in file. Cannot parse.");
            throw new ParserException();
        }
        Magazine magazine = new Magazine(author,title,pagesAmount,publishingHouse);
        return magazine;
    }
}
