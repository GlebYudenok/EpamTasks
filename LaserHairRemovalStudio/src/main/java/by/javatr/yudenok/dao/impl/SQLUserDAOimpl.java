package by.javatr.yudenok.dao.impl;
import by.javatr.yudenok.dao.UserDAO;
import by.javatr.yudenok.domain.*;
import by.javatr.yudenok.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class SQLUserDAOimpl implements UserDAO {

    /**
     * URL to connect to database.
     */
    private String URL =
            "jdbc:mysql://localhost:3306/laserhairremovalstudiodb?"
                    + "useUnicode=true&serverTimezone=UTC&useSSL"
                    + "=true&verifyServerCertificate=false";

    /**
     * default constructor.
     */
    public SQLUserDAOimpl() {

    }

    /**
     * User authorization method.
     * @param login users login
     * @param password users password
     * @return user object
     * @throws SQLException exception linked with database connection n sql.
     */
    @Override
    public User read(final String login, final String password)
            throws SQLException {

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String sql = "SELECT * FROM user WHERE login = ? AND password = ?";

        Connection connection =
                DriverManager.getConnection(URL, "student", "pass123");

        User user = null;
        Account account = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Role role = null;

            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                account = new Account();
                user.setId(resultSet.getInt("id"));
                account.setLogin(login);
                account.setPassword(password);
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setPhoneNumber(resultSet.getLong(6));
                user.setAccount(account);
                role = Role.getById(resultSet.getInt("role"));
                user.setRole(role);
            }
            connection.close();
            resultSet.close();
            statement.close();
            return user;
    }

    /**
     * read all data from database.
     * @return list of users
     * @throws SQLException exception
     * linked with access to database
     */
    @Override
    public List<User> read() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String sql = "SELECT *from user";
        Connection connection =
                DriverManager.getConnection(URL, "student", "pass123");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<User> users = new ArrayList<>();
        while (rs.next()){
            users.add(
                    new User(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getLong("phone_number"),
                            new Account(rs.getString("login"),
                            rs.getString("password")),
                            Role.getById(rs.getInt("role"))));
        }

        return users;
    }


    public User registration(User user) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        Connection connection =
                DriverManager.getConnection(URL, "student", "pass123");

        String sql = "INSERT INTO `user` (`name`,`surname`," +
                "`login`, `password`, `phone_number`," +
                "`role`)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getAccount().getLogin());
            statement.setString(4, user.getAccount().getPassword());
            statement.setLong(5, user.getPhoneNumber());
            statement.setInt(6, user.getRole().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                 resultSet.getInt(1);
                 return user;
            } else {
                new Exception();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        statement.close();
        return user;
    }

    @Override
    public Integer create(User entity) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(URL, "student", "pass123");
        String sql = "INSERT INTO user (name, surname, login, password, phone_number, role)\n" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, entity.getName());
            st.setString(2, entity.getSurname());
            st.setString(3, entity.getAccount().getLogin());
            st.setString(4, entity.getAccount().getPassword());
            st.setLong(5, entity.getPhoneNumber());
            st.setInt(6, entity.getRole().getId());

            st.executeUpdate();
            st.close();
            connection.close();
        return 1;
    }

    /**
     * Read data from database by identify number.
     * @param id parameter unique primary key
     * @return user object
     * @throws SQLException An exception that provides
     * information on a database access error or other errors.
     */
    @Override
    public User read(Integer id) throws SQLException {
        User user = new User();
        Account account = new Account();

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String sql = "SELECT *FROM user WHERE id = ?";
        Connection connection = DriverManager.getConnection(URL,
                "student", "pass123");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            user.setId(id);
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            account.setLogin(resultSet.getString(4));
            account.setPassword(resultSet.getString(5));
            user.setAccount(account);
            user.setPhoneNumber(resultSet.getLong(6));
            user.setRole(Role.getById(resultSet.getInt(7)));
        }
        connection.close();
        preparedStatement.close();
        resultSet.close();
        return user;
    }


    /**
     * SignIn developing!!!
     * @param user
     * @param id
     * @throws SQLException
     * @throws PersistentException
     */
    @Override
    public void update(User user, Integer id) throws SQLException, PersistentException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection =
                DriverManager.getConnection(URL, "student", "pass123");

        String sql = "UPDATE `user` SET " +
                "`name` = ? , `surname` = ?," +
                "`login` = ?, `password` = ?, " +
                "`phone_number` = ?, `role` = ?" +
                "WHERE `id` = ?";
        user.setId(id);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getAccount().getLogin());
            statement.setString(4, user.getAccount().getPassword());
            statement.setLong(5, user.getPhoneNumber());
            statement.setInt(6, user.getRole().getId());
            statement.setInt(7, user.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
        connection.close();
    }

    /**
     * delete row from database by identify number.
     * @param id identify number of user in database
     * @throws SQLException exception linked with errors with access to database
     */
    @Override
    public void delete(final Integer id) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String sql = "DELETE FROM user WHERE id = ?";

        Connection connection =
                DriverManager.getConnection(URL, "student", "pass123");

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,id);
        ps.execute();

        connection.close();
        ps.close();
    }
}
