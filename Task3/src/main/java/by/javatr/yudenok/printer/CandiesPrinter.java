package by.javatr.yudenok.printer;

import by.javatr.yudenok.bean.Candy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CandiesPrinter {

    private static final Logger LOGGER = LogManager.getLogger(CandiesPrinter.class);

    public static void printInfo(List<Candy> candies){
        candies.forEach(LOGGER::info);
    }
}
