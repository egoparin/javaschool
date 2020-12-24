package ru.x5.jpa.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ru.x5.jpa.model.User;

/**
 * @author egor.oparin@x5.ru
 */
public interface UserRepository extends MongoRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findПожалуйстаByNameLike(String nameLike);

    List<User> findTop3ByOrderByNameDesc();

    List<User> findByNameEndingWith(String ending);

    @Query(nativeQuery = true, value = "select * from user where name = 'Oleg'")
    User findOleg();
}
