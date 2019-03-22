package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.config.ContextAuthentication;
import ru.prilepskiy.exception.UnauthorizedException;
import ru.prilepskiy.service.UserService;

import java.security.Principal;


@RequestMapping("/auth")
@RestController
public class SecureController {

    @Autowired
    UserService userService;

    @Autowired
    ContextAuthentication contextAuthentication;

    @GetMapping("/user")
    public String getPrincipal(Principal principal) {
        if (principal != null) {
            return principal.getName();
        } else {
            return "";
        }
    }

    @PostMapping("/login")
    public boolean login(String login, String password) {
        return this.contextAuthentication.auth(login, password);
    }

    @PostMapping("/registration")
    public boolean registration(String login, String password) {
        if (this.userService.findByLogin(login).isPresent()) {
            throw new UnauthorizedException();
        } else {
            this.userService.save(login, password);
            return this.contextAuthentication.auth(login, password);
        }
    }
}
