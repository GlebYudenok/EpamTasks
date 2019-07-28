package by.javatr.yudenok.dao;

import by.javatr.yudenok.domain.User;
import by.javatr.yudenok.exception.PersistentException;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends DAO<User>{
    User read(String login, String password) throws SQLException;
    List<User> read() throws PersistentException, SQLException;
}
