package mvc.service;

import java.util.List;
import mvc.domain.Car;
import mvc.repository.CarStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author egor.oparin@x5.ru
 */
@Service
public class CarService {
    @Autowired
    CarStore carStore;

    public void register(Car car){
        carStore.addCar(car);
    }

    public void unRegister(Car car){
        carStore.deleteCar(car);
    }

    public Car get (String number){
        for (Car car : carStore.getCarStore()) {
            if(number.equals(car.getNumber())){
                return car;
            }
        }
        throw new RuntimeException("Car not found");
    }

    public List<Car> getAll(){
        return carStore.getCarStore();
    }
}
