package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.entity.Role;
import ru.prilepskiy.entity.User;
import ru.prilepskiy.service.UserService;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/echo")
    public String echo() {
        return "Echo OK";
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return this.userService.findAll();
    }

    @GetMapping("/user")
    public User save(String id, String name) {
        User user = new User(id, name);
        user.getRoles().addAll(Arrays.asList(new Role("1", "Admin"), new Role("2", "Developer")));
        return this.userService.save(user);
    }

}
