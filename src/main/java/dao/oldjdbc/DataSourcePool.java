package dao.oldjdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * @author egor.oparin@x5.ru
 */
public class DataSourcePool {

    private DataSourcePool(){}

    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        basicDataSource.setUsername("postgres");
        basicDataSource.setPassword("postgres");

        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUrl("oldjdbc:postgresql://localhost:5432/car_manag");
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(10);
    }


    public static Connection getConnection() throws SQLException {
        return basicDataSource.getConnection();
    }

}
