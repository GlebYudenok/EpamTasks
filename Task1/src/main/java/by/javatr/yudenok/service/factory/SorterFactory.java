package by.javatr.yudenok.service.factory;

import by.javatr.yudenok.exception.ServiceException;
import by.javatr.yudenok.service.SorterService;

public class SorterFactory {
    public static void sort(SorterService sorterService) throws ServiceException {
        sorterService.sort();
    }
}
