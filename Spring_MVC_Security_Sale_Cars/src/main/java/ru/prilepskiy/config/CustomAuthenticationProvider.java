package ru.prilepskiy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import ru.prilepskiy.entity.UserEntity;
import ru.prilepskiy.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        Iterable<UserEntity> users = this.userService.findByLoginAndPassword(login, password);
        if (users.iterator().hasNext()) {
            UserEntity user = users.iterator().next();
            return new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), new ArrayList<>());
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
