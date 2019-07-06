package by.javatr.yudenok.dao.factory;

import by.javatr.yudenok.dao.impl.SQLPicturesDAOimpl;
import by.javatr.yudenok.dao.impl.SQLUserDAOimpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final SQLUserDAOimpl sqlUserDAOimpl = new SQLUserDAOimpl();
    private final SQLPicturesDAOimpl SQLPicturesDAOimpl = new SQLPicturesDAOimpl();

    private DAOFactory() {

    }

    public static DAOFactory getInstance(){
        return instance;
    }

    public SQLUserDAOimpl getSqlUserDaoImpl() {
        return sqlUserDAOimpl;
    }

    public SQLPicturesDAOimpl getSQLPicturesDAOimpl() {
        return SQLPicturesDAOimpl;
    }
}
