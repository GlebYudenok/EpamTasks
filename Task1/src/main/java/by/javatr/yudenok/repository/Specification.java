package by.javatr.yudenok.repository;

public interface Specification <T>{
    boolean match(T entity);
}
