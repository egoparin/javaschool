package dao.oldjdbc.impl;

import dao.oldjdbc.Dao;
import dao.oldjdbc.DataSourcePool;
import dao.oldjdbc.exceptions.DaoException;
import domain.oldjdbc.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author egor.oparin@x5.ru
 */
public class DbCarDao implements Dao<Car> {

    private final String INSERT_QUERY = "insert into car (vin, color, model, price) VALUES (?,?,?,?) ";

    @Override
    public void insert(Car item) throws DaoException {

        try (
                Connection connection = DataSourcePool.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)
        ) {
            statement.setString(1, item.getVin());
            statement.setString(2, item.getColor());
            statement.setString(3, item.getModel());
            statement.setDouble(4, item.getPrice());

            statement.executeQuery();

        } catch (SQLException e) {
            //logger.error("error insert", e);
            throw new DaoException("error insert" , e);
        }
    }

    @Override
    public void delete(Car item) {

    }

    @Override
    public Car getById(int id) {
        return null;
    }
}
