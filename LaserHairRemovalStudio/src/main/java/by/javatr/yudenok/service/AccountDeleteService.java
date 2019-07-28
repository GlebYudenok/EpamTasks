package by.javatr.yudenok.service;

import by.javatr.yudenok.dao.factory.DAOFactory;
import by.javatr.yudenok.dao.impl.SQLUserDAOimpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class AccountDeleteService {

    private static final SQLUserDAOimpl userDAOimpl =
            DAOFactory.getInstance().getSqlUserDaoImpl();

    public void delete(HttpServletRequest request) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAOimpl.delete(id);
    }
}
