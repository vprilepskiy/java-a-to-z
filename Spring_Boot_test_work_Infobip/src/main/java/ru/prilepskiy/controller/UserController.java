package ru.prilepskiy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.response.Account;

@RestController
public class UserController {
    @GetMapping("/register")
    public Account register(String url) {
        return new Account(true, "Your account is opened", "pass");
    }

    //TODO: Написать контроллеры.
    //TODO: Добавить генерацию пароля.
    //TODO: Добавить в return shortened URL.

}
