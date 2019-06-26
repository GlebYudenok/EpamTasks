package by.javatr.yudenok.service;

import by.javatr.yudenok.bean.Candy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class CandiesPrinter {

    /**
     * logger, in which will print info about
     * parsing file and print toString of objects.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(CandiesPrinter.class);

    /**
     * private constructor.
     */
    private CandiesPrinter() {

    }

    /**
     * write to logfile.
     * @param candies
     */
    public static void printInfo(final List<Candy> candies) {
        candies.forEach(LOGGER::info);
    }
}
