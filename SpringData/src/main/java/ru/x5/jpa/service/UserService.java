package ru.x5.jpa.service;

import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.x5.jpa.model.User;
import ru.x5.jpa.repository.UserRepository;

/**
 * @author egor.oparin@x5.ru
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional()
    public void insertUser(){
        log.info("Start insert with transaction ");

        for (int i = 0; i < 5; i++) {
            User user = new User("vova", "v@");
            userRepository.save(user);
            if(i==2){
                throw new RuntimeException("No insert");
            }
        }
    }

    public void insertUserWithoutT(){
        log.info("Start insert without transaction ");

        for (int i = 0; i < 5; i++) {
            User user = new User("vova", "v@");
            userRepository.save(user);
            if(i==2){
                throw new RuntimeException("No insert");
            }
        }
    }

}
