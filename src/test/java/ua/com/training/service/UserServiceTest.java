package ua.com.training.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.training.dao.UserRepository;
import ua.com.training.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void testFindUserByLoginAndPassword() {
        User test = new User();
        test.setLogin("test");
        test.setPassword("+++");
        userRepository.save(test);
        entityManager.flush();
        entityManager.detach(test);

//        Optional<User> userFromDB = userRepository.findByLoginAndPasswordAndRole("test", "+++");
//        userFromDB.orElse(new User());
//
//        assertThat(userFromDB.orElse(new User()),equalTo(test));
    }
}