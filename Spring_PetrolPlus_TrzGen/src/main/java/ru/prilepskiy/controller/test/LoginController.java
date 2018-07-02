package ru.prilepskiy.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by VLADIMIR on 12.04.2018.
 */
@Controller
public class LoginController {

    /**
     * Test.
     * Сокращенная запись goGet @RequestMapping("/test").
     * @return
     */
    @RequestMapping("/test")
    public String getTestPage() {
        return "Test text!";
    }


    /**
     * Метод принимает атрибут "error" или "logout".
     *  Пример: url:http://localhost:8082/login?logout
     *  или http://localhost:8082/login?error
     * required = false указывает на то что атрибут не обязательный (может отсутствовать)
     *
     * @param error - RequestParam.
     * @param logout - RequestParam.
     * @param model - Модель. (Сервлет сессия - т.е. карта атрибутов.)
     * @return - название модели.
     *
     *
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model) {
        // добавить атрибуты
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }
}
