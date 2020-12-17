package ru.x5.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x5.jpa.domain.Car;

/**
 * @author egor.oparin@x5.ru
 */
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}

