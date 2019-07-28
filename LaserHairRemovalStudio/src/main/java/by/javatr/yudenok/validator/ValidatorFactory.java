package by.javatr.yudenok.validator;

import by.javatr.yudenok.domain.Entity;
import by.javatr.yudenok.domain.User;

import java.awt.print.Book;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {
    private static Map<Class<? extends Entity>, Class<? extends Validator<?>>> validators = new HashMap<>();

    static {
        validators.put(User.class, UserValidator.class);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Entity> Validator<T> createValidator(Class<T> entity) {
        try {
            return (Validator<T>)validators.get(entity).newInstance();
        } catch(InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
}
