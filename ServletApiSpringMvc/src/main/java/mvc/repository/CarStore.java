package mvc.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mvc.domain.Car;
import org.springframework.stereotype.Repository;

/**
 * @author egor.oparin@x5.ru
 */
@Repository
public class CarStore {
    private static List<Car> carStore;

    static {
        carStore = new ArrayList<>();
        carStore.add(new Car("BMW", "H435CB"));
        carStore.add(new Car("Mercedes", "M563TB"));
        carStore.add(new Car("Mazda", "M012CE"));
        carStore.add(new Car("Ferrari", "C634CC"));
        carStore.add(new Car("Bentley", "A111AA"));
    }

    public static List<Car> getStore(){
        return carStore;
    }

    public List<Car> getCarStore(){
        return carStore;
    }

    public void addCar(Car car){
        carStore.add(car);
    }

    public void deleteCar(Car car){
        carStore.remove(car);
    }

}
