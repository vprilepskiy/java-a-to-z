package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.prilepskiy.domain.Role;
import ru.prilepskiy.domain.User;
import ru.prilepskiy.repository.RoleRepository;
import ru.prilepskiy.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.Arrays;

/**
 * Created by VLADIMIR on 09.04.2018.
 *
 * Бизнес логика.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Выполнится перед созданием экземпляра класса.
     *
     * Сохранить дефолтную роль.
     */
    @PostConstruct
    public void init() {
        if (this.roleRepository.findByAuthority("USER") == null) {
            final Role role = new Role("USER");
            this.roleRepository.save(role);
        }
    }

    /**
     * Найти юзера по имени. Метод требуется для авторизации.
     * @param username
     * @return
     * @throws UsernameNotFoundException - если не найден, выкинуть исключение.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserDetails userDetails = this.userRepository.findByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User " + username + " was not found!");
        }
        return userDetails;
    }


    /**
     * Добавить нового юзера.
     * @param login
     * @param password
     * @return
     */
    public User addUser(String login, String password) {
        User result = null;
        if (this.userRepository.findByUsername(login) == null) {
            final Role role = this.roleRepository.findByAuthority("USER");
            final User user = new User();
            user.setAuthorities(Arrays.asList(role));
            user.setUsername(login);
            // зашифоровать пароль
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            result = this.userRepository.save(user);
        }
        return result;
    }




    /**
     * Получить всех пользователей.
     * @return
     */
    public Iterable<User> getAll() {
        return this.userRepository.findAll();
    }


    /**
     * Получить по id.
     * @param id
     * @return
     */
    public User getById(Integer id) {
        return this.userRepository.findOne(id);
    }


    /**
     * Добавить юзера.
     * @param user
     */
    public User add(User user) {
        return this.userRepository.save(user);
    }


    public String getGuId() {
        return this.userRepository.getGuId();
    }

    public void deleteUser(Integer id) {
        this.userRepository.delete(id);
    }
}
