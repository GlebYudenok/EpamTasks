package by.javatr.yudenok.service;

import by.javatr.yudenok.dao.UserDAO;
import by.javatr.yudenok.dao.factory.DAOFactory;
import by.javatr.yudenok.dao.impl.SQLUserDAOimpl;
import by.javatr.yudenok.domain.Picture;
import by.javatr.yudenok.domain.User;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class UserSignUpService {
    private final UserDAO sqlUserDAO = new SQLUserDAOimpl();

    private static final DAOFactory factory = DAOFactory.getInstance();
    private static final SQLUserDAOimpl userDAOimpl = factory.getSqlUserDaoImpl();

    public User signUp(String login, String password) throws SQLException {
        User user = null;

        try {
            user = userDAOimpl.read(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        userDAOimpl.registration(user);
        return user;
    }
}
