package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prilepskiy.entity.UserEntity;
import ru.prilepskiy.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<UserEntity> findByLoginAndPassword(String login, String password) {
        return this.userRepository.findByLoginAndPassword(login, password);
    }

    public Iterable<UserEntity> findByLogin(String login) {
        return this.userRepository.findByLogin(login);
    }

    public UserEntity save(String login, String password) {
        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setPassword(password);
        return this.userRepository.save(user);
    }
}
