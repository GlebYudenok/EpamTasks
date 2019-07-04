package by.javatr.yudenok.dao.impl;
import by.javatr.yudenok.dao.UserDAO;
import by.javatr.yudenok.domain.Account;
import by.javatr.yudenok.domain.Entity;
import by.javatr.yudenok.domain.Role;
import by.javatr.yudenok.domain.User;

import java.sql.*;

public class SQLUserDAO implements UserDAO {

    private static final SQLUserDAO instance = new SQLUserDAO();
    private String URL = "jdbc:mysql://localhost:3306/laserhairremovalstudiodb?" +
            "useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

    private SQLUserDAO(){

    }

    public static SQLUserDAO getInstance(){
        return instance;
    }

    @Override
    public User singIn(String login, String password) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String sql = "SELECT * FROM user WHERE login = ? AND password = ?";

        User user = null;
        Account account = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Role role = null;

            Connection connection = DriverManager.getConnection(URL,"student","pass123");
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                user = new User();
                account = new Account();
                user.setId(resultSet.getInt("id"));
                account.setLogin(login);
                account.setPassword(password);
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setPhoneNumber(resultSet.getLong(6));
                user.setAccount(account);
                role=Role.getById(resultSet.getInt("role"));
                user.setRole(role);
            }

            return user;
    }

    @Override
    public User registration(Account account) {
        return null;
    }

    @Override
    public Integer create(Entity entity) {
        System.out.println("создаем");
        return 1;
    }

    @Override
    public Entity read(Integer id) {
        return null;
    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(Integer id) {

    }
}
