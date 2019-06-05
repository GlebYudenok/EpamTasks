package by.javatr.yudenok.exception;

public class SpecificatorException extends Exception{
    public SpecificatorException()
    {
        super();
    }

    public SpecificatorException(String message){
        super(message);
    }

    public SpecificatorException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SpecificatorException(Throwable cause){
        super(cause);
    }
}
