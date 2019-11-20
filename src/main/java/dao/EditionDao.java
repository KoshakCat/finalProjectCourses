package dao;

import bd.DataSourceFactory;
import entity.Edition;
import enums.EditionType;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EditionDao {

    private static final Logger LOG = Logger.getLogger(EditionDao.class);
    private static final String READ = "SELECT * FROM edition";
    private static final String CREATE = "INSERT INTO edition (id , name, type, cost, circulation) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE edition SET id = ?, name = ?, type = ?, cost = ?, circulation = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM edition WHERE id = ?";


    public List<Edition> read () {
        List<Edition> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(READ);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                EditionType editionType = EditionType.valueOf(resultSet.getString("type"));
                double subscriptionCost = resultSet.getDouble("cost");
                int circulation = resultSet.getInt("circulation");
                String editionName = resultSet.getString("name");
                result.add(new Edition(id, editionName, editionType, subscriptionCost, circulation));
                LOG.info("Read from bd done success");
            }
        } catch (SQLException e) {
            LOG.error("Read from bd failed", e);
        }

        return result;
    }

    public int create (Edition edition) {

        int id = edition.getId();
        EditionType editionType = edition.getEditionType();
        double subscriptionCost = edition.getSubscriptionCost();
        int circulation = edition.getCirculation();
        String editionName = edition.getEditionName();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataSourceFactory.getPreparedStatement(CREATE);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, editionName);
            preparedStatement.setString(3, editionType.toString());
            preparedStatement.setDouble(4, subscriptionCost);
            preparedStatement.setInt(5, circulation);
            int result = preparedStatement.executeUpdate();
            LOG.info("Create procedure done success");
            return result;
        } catch (SQLException e) {
            LOG.error("Create procedure failed", e);
            return -1;
        }
    }

    public int update (Edition edition) {

        int id = edition.getId();
        EditionType editionType = edition.getEditionType();
        double subscriptionCost = edition.getSubscriptionCost();
        int circulation = edition.getCirculation();
        String editionName = edition.getEditionName();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = DataSourceFactory.getPreparedStatement(UPDATE);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, editionName);
            preparedStatement.setString(3, editionType.toString());
            preparedStatement.setDouble(4, subscriptionCost);
            preparedStatement.setInt(5, circulation);
            preparedStatement.setInt(6,id);

            int result = preparedStatement.executeUpdate();
            LOG.info("UPDATE procedure done success");
            return result;
        } catch (SQLException e) {
            LOG.error("UPDATE procedure failed", e);
            return -1;
        }
    }

    public int delete (int id) {

        int idWhere = id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataSourceFactory.getPreparedStatement(DELETE);
            preparedStatement.setInt(1,idWhere);
            int result = preparedStatement.executeUpdate();
            LOG.info("DELETE procedure done success");
            return result;
        } catch (SQLException e) {
            LOG.error("DELETE procedure failed", e);
            return -1;
        }
    }

}
