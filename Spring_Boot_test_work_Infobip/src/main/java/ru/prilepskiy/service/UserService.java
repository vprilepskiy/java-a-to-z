package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.prilepskiy.entity.RoleEntity;
import ru.prilepskiy.entity.UserEntity;
import ru.prilepskiy.repository.RoleRepository;
import ru.prilepskiy.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        if (this.roleRepository.findByAuthority("USER") == null) {
            final RoleEntity role = new RoleEntity("USER");
            this.roleRepository.save(role);
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

    public Optional<UserEntity> addUser(String login) {
        if (this.userRepository.findByUsername(login) != null) {
            return Optional.empty();
        } else {
            final RoleEntity role = this.roleRepository.findByAuthority("USER");
            final UserEntity user = new UserEntity();
            user.setAuthorities(Arrays.asList(role));
            user.setUsername(login);
            // зашифоровать пароль
            user.setPassword(new BCryptPasswordEncoder().encode("1111"));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            return Optional.of(this.userRepository.save(user));
        }
    }
}
