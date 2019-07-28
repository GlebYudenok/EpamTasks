package by.javatr.yudenok.dao.impl;

import by.javatr.yudenok.dao.DAO;
import by.javatr.yudenok.domain.Picture;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;

public class SQLPicturesDAOimpl implements DAO<Picture> {

    /**
     * URL to connect to database.
     */
    private String URL =
            "jdbc:mysql://localhost:3306/laserhairremovalstudiodb?"
                    + "useUnicode=true&serverTimezone=UTC&useSSL"
                    + "=true&verifyServerCertificate=false";

    @Override
    public Integer create(Picture entity) throws SQLException {
        return null;
    }

    @Override
    public Picture read(Integer id) throws SQLException {
        Picture picture = new Picture();
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String sql = "SELECT *FROM picture WHERE id = ?";
        Connection connection = DriverManager.getConnection(URL, "student",
                 "pass123");
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            picture.setId(id);
            picture.setName(rs.getString(2));
            picture.setLink(rs.getString(3));
        }
        connection.close();
        rs.close();
        ps.close();
        return picture;
    }

    @Override
    public void update(Picture entity, Integer id) throws SQLException {

    }

    @Override
    public void delete(Integer id) throws SQLException {

    }
}
