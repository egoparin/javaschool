package ru.x5.jpa.repository;


import java.util.Arrays;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import ru.x5.jpa.config.MainConfig;
import ru.x5.jpa.model.Role;
import ru.x5.jpa.model.RoleEnum;
import ru.x5.jpa.model.User;

/**
 * @author egor.oparin@x5.ru
 */
@Slf4j
@SpringBootTest(classes = { UserRepository.class, MainConfig.class})
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    @Rollback(false)
    public void setUp(){
        User ivan = new User("Ivanov ivan", "ivan@mail.ru");
        User petr = new User("Ivanov petr", "ivan@mail.ru");

        User jeka = new User("mr Jenni", "jenni@mail.ru");
        jeka.addRole(new Role(RoleEnum.ADMIN.getCode()));
        jeka.addRole(new Role(RoleEnum.OWNER.getCode()));

        User oleg = new User("Oleg", "oleg@mail.ru");
        jeka.addRole(new Role(RoleEnum.SIMPLE.getCode()));

        userRepository.saveAll(Arrays.asList(ivan, jeka, oleg, petr));

        log.info("***** init done *****");
    }


    @Test
    public void testGetAll(){
        log.info("***************************************** GetAll *****");
        Iterable<User> users = userRepository.findAll();

        for (User user : users) {
            log.info(user.getName());
        }
        log.info("***** ***** *****");
    }

    @Test
    public void testGetAndSortAll(){
        log.info("***************************************** GetAllANdSort *****");
        Iterable<User> users = userRepository.findAll(Sort.by(Direction.DESC, "name"));

        for (User user : users) {
            log.info(user.getName());
        }
        log.info("***** ***** *****");
    }

    @Test
    public void testFindByName(){
        log.info("***************************************** findByName *****");
        log.info(userRepository.findByName("Oleg").toString());
        log.info("***** ***** *****");
    }

    @Test
    public void testFindByNameLike(){
        log.info("***************************************** findByNameLike *****");
        log.info(userRepository.findПожалуйстаByNameLike("%Ivanov%").toString());
        log.info("***** ***** *****");
    }

    @Test
    public void testFindTop(){
        log.info("***************************************** FindTop *****");
        Iterable<User> users = userRepository.findTop3ByOrderByNameDesc();

        for (User user : users) {
            log.info(user.getName());
        }
        log.info("***** ***** *****");
    }

    @Test
    public void testFindEnding(){
        log.info("***************************************** testFindEnding *****");
        Iterable<User> users = userRepository.findByNameEndingWith("an");

        for (User user : users) {
            log.info(user.getName());
        }
        log.info("***** ***** *****");
    }


    @Test
    public void testFindOleg(){
        log.info("***************************************** findOleg *****");
        log.info(userRepository.findOleg().toString());
        log.info("***** ***** *****");
    }


}
