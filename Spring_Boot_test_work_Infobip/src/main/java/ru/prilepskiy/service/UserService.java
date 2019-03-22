package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prilepskiy.entity.UserEntity;
import ru.prilepskiy.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Optional<UserEntity> findByLoginAndPassword(String login, String password) {
        UserEntity user = this.userRepository.findFirstByLogin(login);
        if (user != null && this.bcryptPasswordEncoder().matches(password, user.getPassword())) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    public Optional<UserEntity> findByLogin(String login) {
        return Optional.ofNullable(this.userRepository.findFirstByLogin(login));
    }

    public UserEntity save(String login, String password) {
        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setPassword(this.bcryptPasswordEncoder().encode(password));
        return this.userRepository.save(user);
    }
}
