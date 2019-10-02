package ru.prilepskiy.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.service.SchoolService;

@Deprecated
@RestController
@RequestMapping("/dsl")
public class DslRestController {

    public DslRestController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    private final SchoolService schoolService;

    @GetMapping(path = "/echo")
    public String echo() {
        return "echo";
    }

    @GetMapping(path = "/dsl")
    public Integer dsl() {
        return this.schoolService.dsl();
    }

    @GetMapping(path = "/jpa")
    public Integer jpa() {
        return this.schoolService.jpa();
    }
}

