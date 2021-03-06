package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.config.CustomAuthenticationProvider;
import ru.prilepskiy.service.UserService;

import java.security.Principal;


@RequestMapping("/auth")
@RestController
public class SecureController {

    @Autowired
    UserService userService;

    @Autowired
    CustomAuthenticationProvider authenticationProvider;

    @GetMapping("/user")
    public String getPrincipal(Principal principal) {
        if (principal != null) {
            return principal.getName();
        } else {
            return "";
        }
    }

    @PostMapping("/login")
    public String login(String login, String password) {
        return this.setContextAuthentication(login, password);
    }

    @PostMapping("/registration")
    public String registration(String login, String password) {
        if (this.userService.findByLogin(login).iterator().hasNext()) {
            return "Registration error!";
        } else {
            this.userService.save(login, password);
            return this.setContextAuthentication(login, password);
        }
    }

    private String setContextAuthentication(String login, String password) {
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
