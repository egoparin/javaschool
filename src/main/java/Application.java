import dao.oldjdbc.Dao;
import dao.oldjdbc.DataSourcePool;
import dao.oldjdbc.exceptions.DaoException;
import dao.oldjdbc.impl.CarDaoFacrory;


import domain.jpa.Car;
import domain.jpa.Driver;
import examples.annotation.Animal;
import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

/**
 * @author egor.oparin@x5.ru
 */
public class Application {

    public static void main(String[] args) {

        boolean re =Double.compare(-1, -2) < 0;
        System.out.println(re);


        Car car = new Car();
        car.setColor("yellow");
        car.setModel("camry");
        car.setPrice(2000.00);

        Driver driver = new Driver();
        driver.setName("Ivanov");
        driver.setCars(Collections.singletonList(car));


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(car);
        em.persist(driver);
        em.getTransaction().commit();
        em.close();
        Object j = new Object();

        try {
            Connection c  = DataSourcePool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
