package by.javatr.yudenok.presentation;

import by.javatr.yudenok.dao.impl.SQLUserDAO;
import by.javatr.yudenok.domain.User;
import by.javatr.yudenok.validator.UserValidator;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SQLUserDAO dao = SQLUserDAO.getInstance();
        User user = dao.singIn("NoFantasy","noFantasy228");
        System.out.println(user);
    }
}
