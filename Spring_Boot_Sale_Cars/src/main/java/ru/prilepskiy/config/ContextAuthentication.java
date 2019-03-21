package ru.prilepskiy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ContextAuthentication {

    @Autowired
    CustomAuthenticationProvider authenticationProvider;

    public String set(String login, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login, password);
        Authentication auth = this.authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
        if (auth == null) {
            return "Auth error!";
        }
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        return "Ok";
    }

}
