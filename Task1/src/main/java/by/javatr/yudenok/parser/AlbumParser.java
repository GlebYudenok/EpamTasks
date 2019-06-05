package by.javatr.yudenok.parser;

import by.javatr.yudenok.bean.Album;
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

public class AlbumParser {

    private static final Logger logger = LogManager.getLogger(AlbumParser.class);

    public static List<Album> parse(File path) throws IOException, ParserException {

        Library.getInstance().getAlbumList().removeAll(Library.getInstance().getAlbumList());

        List<String> parserList = new ArrayList<>();

        parserList = fileRead(path);

        String []arr = new String[parserList.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = parserList.get(i);
        }

        for(int i = 0; i < arr.length; i++) {
            String[] s = arr[i].split(" ");

            try {
                Library.getInstance().getAlbumList().add(toLibrary(s));
            } catch (ParserException e) {
                logger.warn("Stop reading and parsing.");
                Library.getInstance().getAlbumList().removeAll(Library.getInstance().getAlbumList());
                break;
            }

        }
        return Library.getInstance().getAlbumList();
    }

    private static List<String> fileRead(File filePath) throws IOException {

        RandomAccessFile file = new RandomAccessFile(filePath,"r");

        List<String> s = new ArrayList<String>();

        for(int i = 0; i < FileLinesCounterService.countLines(filePath.toString()); i++){
            s.add(file.readLine());
        }
        return s;
    }

    private static Album toLibrary(String []s) throws ParserException {

        Library library = Library.getInstance();

        String company;
        int pagesAmount;

        try {
            company = s[0].toString();
            pagesAmount = Integer.parseInt(s[1]);
        }catch (Exception e){
            logger.error("Wrong datas in file. Cannot parse.");
            throw new ParserException();
        }

        Album album = new Album(company, pagesAmount);

        return album;
    }
}
