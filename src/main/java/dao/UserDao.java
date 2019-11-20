package dao;

import bd.DataSourceFactory;

import entity.Edition;
import entity.User;

import enums.EditionType;
import enums.Role;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final Logger LOG = Logger.getLogger(UserDao.class);
    private static final String READ = "SELECT * FROM edition_user";


    public List<User> read () {
        List<User> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(READ);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Role role = Role.valueOf(resultSet.getString("role"));
                String name = resultSet.getString("name");
                String pass = resultSet.getString("pass");
                result.add(new User(id, name , pass, role));
                LOG.info("Read from bd done success");
            }
        } catch (SQLException e) {
            LOG.error("Read from bd failed", e);
        }

        return result;
    }

}
