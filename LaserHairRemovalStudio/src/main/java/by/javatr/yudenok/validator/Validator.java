package by.javatr.yudenok.validator;

import by.javatr.yudenok.domain.Entity;
import by.javatr.yudenok.exception.IncorrectFormDataException;

import javax.servlet.http.HttpServletRequest;

public interface Validator <T extends Entity> {
    T validate(HttpServletRequest request) throws IncorrectFormDataException;
    boolean isNull(T entity);
}
