package by.javatr.yudenok.exception;

public class IncorrectFormDataException extends Exception{
    public IncorrectFormDataException() {
    }

    public IncorrectFormDataException(String message) {
        super(message);
    }

    public IncorrectFormDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectFormDataException(Throwable cause) {
        super(cause);
    }

    public IncorrectFormDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
