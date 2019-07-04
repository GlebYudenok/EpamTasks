package by.javatr.yudenok.dao;

import by.javatr.yudenok.domain.Entity;

public interface DAO <T extends Entity> {
    Integer create(T entity);
    T read(Integer id);
    void update(T entity);
    void delete(Integer id);
}
