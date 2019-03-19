package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;
import ru.prilepskiy.config.CustomAuthenticationProvider;
import ru.prilepskiy.service.UserService;

import java.security.Principal;
import java.util.Optional;


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
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login, password);
        Authentication auth = this.authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
        if (auth == null) {
            return "Auth error!";
        }
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        return "Ok";
    }

    @PostMapping("/registration")
    public String registration(String login, String password) {
        return this.userService.registration(login, password);
    }

}
