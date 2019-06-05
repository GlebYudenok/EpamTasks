package by.javatr.yudenok.repository;

import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.RepositoryException;
import by.javatr.yudenok.exception.SpecificatorException;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    void read() throws RepositoryException, IOException, ParserException;
    void update() throws IOException;
    void remove(T entity) throws RepositoryException;
    List<T> find(Specification specification) throws SpecificatorException, RepositoryException;
    void removeAll(Specification specification) throws SpecificatorException, RepositoryException;
    void add(T entity) throws RepositoryException;
}
