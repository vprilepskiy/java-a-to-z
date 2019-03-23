package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.entity.UserEntity;
import ru.prilepskiy.response.Account;
import ru.prilepskiy.service.UserService;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/account")
    public Account register(String accountId) {
        Optional<String> password = this.userService.saveUserIfNotExistAndGetPassword(accountId);
        if (password.isPresent()) {
            return new Account(true, "Your account is opened", password.get());
        } else {
            return new Account(false, "Description of status, for example: account with that ID already exists", null);
        }
    }
}
