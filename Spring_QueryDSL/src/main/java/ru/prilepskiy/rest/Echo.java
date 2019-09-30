package ru.prilepskiy.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.service.SchoolService;

@RestController
public class Echo {

    public Echo(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    private final SchoolService schoolService;

    @GetMapping(path = "/echo")
    public String echo() {
        return "echo";
    }

    @GetMapping(path = "/jpa")
    public Integer dsl() {
        return this.schoolService.dsl();
    }

    @GetMapping(path = "/jpa")
    public Integer jpa() {
        return this.schoolService.jpa();
    }
}

