package ru.prilepskiy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.response.Register;

@RestController
public class UserController {
    @GetMapping("/register")
    public Register register(String url) {
        return new Register(true, "Your account is opened", "pass");
    }

}
