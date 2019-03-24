package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.prilepskiy.entity.RoleEntity;
import ru.prilepskiy.entity.UserEntity;
import ru.prilepskiy.helper.Utils;
import ru.prilepskiy.repository.RoleRepository;
import ru.prilepskiy.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final String defaultRole = "USER";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private Utils utils;

    @PostConstruct
    public void init() {
        if (this.roleRepository.findByAuthority(defaultRole) == null) {
            this.roleRepository.save(new RoleEntity(defaultRole));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserDetails userDetails = this.userRepository.findByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User " + username + " was not found!");
        }
        return userDetails;
    }

    public Optional<String> saveUserIfNotExistAndGetPassword(String login) {
        if (this.userRepository.findByUsername(login) != null) {
            return Optional.empty();
        } else {
            final RoleEntity role = this.roleRepository.findByAuthority(defaultRole);
            final UserEntity user = new UserEntity();
            user.setAuthorities(Arrays.asList(role));
            user.setUsername(login);
            String password = this.utils.generatePassword();
            // зашифоровать пароль
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            this.userRepository.save(user);
            return Optional.of(password);
        }
    }
}
