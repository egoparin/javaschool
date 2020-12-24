package ru.x5.jpa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.x5.jpa.model.IUser;
import ru.x5.jpa.model.User;
import ru.x5.jpa.repository.UserRepository;
import ru.x5.jpa.service.UserService;

/**
 * @author egor.oparin@x5.ru
 */
@SpringBootApplication(scanBasePackages = "ru.x5.jpa")
@Slf4j
public class Application implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Autowired
    MongoTemplate mongoTemplate;


    class UserMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            return user;
        }
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //List<User> users = jdbcTemplate.query("select * from user",  new UserMapper());

        List<User> users = mongoTemplate.findAll(User.class);
        log.info(users.toString());
    }
}

