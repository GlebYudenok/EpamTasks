package by.javatr.yudenok.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileLinesCounterService {

    private static final Logger logger = LogManager.getLogger(FileLinesCounterService.class);

    public static int countLines(String path) throws IOException {

        logger.info("countLines function is called");

        RandomAccessFile file = new RandomAccessFile(path,"r");
        int count = 0;
        while (file.readLine()!=null){
            count++;
        }
        return count;
    }
}
