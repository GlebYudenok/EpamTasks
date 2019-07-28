package by.javatr.yudenok.service;

import by.javatr.yudenok.dao.factory.DAOFactory;
import by.javatr.yudenok.dao.impl.SQLUserDAOimpl;
import by.javatr.yudenok.domain.Account;
import by.javatr.yudenok.domain.Role;
import by.javatr.yudenok.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class UserSignInService {

    private static final SQLUserDAOimpl sqlUserDAO =
             DAOFactory.getInstance().getSqlUserDaoImpl();

    public User register(HttpServletRequest request) throws SQLException {

        User user = new User();
        Account account = new Account();
        String parameter = request.getParameter("name");
        user.setName(parameter);
        parameter = request.getParameter("surname");
        user.setSurname(parameter);
        parameter = request.getParameter("phone number");
        user.setPhoneNumber(Long.valueOf(parameter));
        parameter = request.getParameter("login");
        account.setLogin(parameter);
        parameter = request.getParameter("pass");
        account.setPassword(parameter);
        user.setRole(Role.USER);
        user.setAccount(account);

        sqlUserDAO.registration(user);
        return user;
    }
}
