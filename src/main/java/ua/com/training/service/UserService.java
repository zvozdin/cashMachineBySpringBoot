package ua.com.training.service;

import org.springframework.stereotype.Service;
import ua.com.training.dao.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
