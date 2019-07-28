package by.javatr.yudenok.dao;

import by.javatr.yudenok.domain.Entity;
import by.javatr.yudenok.exception.PersistentException;

import java.sql.SQLException;

public interface DAO<T extends Entity> {
    /**
     * create dao entity.
     * @param entity entity, by which will execute their functions
     * @return id of entity
     */
    Integer create(T entity) throws SQLException;

    /**
     * read data from database by id.
     * @param id parameter
     * @return entity
     */
    T read(Integer id) throws SQLException;
    void update(T entity, Integer id) throws SQLException, PersistentException;
    void delete(Integer id) throws SQLException;
}
