package ua.com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.training.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginAndPassword(String login, String password);
}
