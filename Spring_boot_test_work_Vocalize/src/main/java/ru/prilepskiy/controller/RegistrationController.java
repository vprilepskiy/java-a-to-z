package ru.prilepskiy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.prilepskiy.domain.User;
import ru.prilepskiy.repository.UserRepository;
import ru.prilepskiy.service.UserService;
import java.security.Principal;

/**
 * Created by VLADIMIR on 09.04.2018.
 */

// url по умолчанию для всех методов
@RequestMapping("/")
@RestController
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Добавит нового юзера.
     * @param login
     * @param password
     * @return
     */
    @PostMapping("/all/registration")
    public String registration(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password) {
        if (this.userService.addUser(login, password) != null) {
            return "Ok";
        }
        return "A user with this name already exists.";
    }


    /**
     * Показать всех пользователей.
     * @return
     */
    @GetMapping("/all/users")
    public Iterable<User> getAllUsers() {
        return this.userService.getAll();
    }


    /**
     * Получить по id.
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User list(@PathVariable Integer id) {
        return this.userService.getById(id);
    }


    /**
     * Добавить пользователя.
     * RequestBody - это значит что объект user придет в виде json.
     * @param user
     * @return
     */
    @PostMapping(path = "/all/addUserJson", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody User user) {
        this.userService.add(user);
        return "redirect:users";
    }


    /**
     * Добавить пользователя.
     * ModelAttribute - это значит что объект user создастся с помощю переданных атрибутов юзера (username, password и т.д.)
     * @param user
     * @return
     */
    @PostMapping("/addUserAttributes")
    public String add0(@ModelAttribute User user) {
        this.userService.add(user);
        return "redirect:users";
    }

    /**
     * Вернет зарегестрированного пользователя.
     * @param principal
     * @return
     */
    @GetMapping("/principal")
    public Principal list(Principal principal) {
        return principal;
    }



}
