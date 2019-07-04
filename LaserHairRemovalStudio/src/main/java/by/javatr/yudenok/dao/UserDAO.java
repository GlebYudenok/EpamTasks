package by.javatr.yudenok.dao;

import by.javatr.yudenok.domain.Account;
import by.javatr.yudenok.domain.User;

import java.sql.SQLException;

public interface UserDAO extends DAO{
    User singIn(String login, String password) throws SQLException;
    User registration(Account account);
}
