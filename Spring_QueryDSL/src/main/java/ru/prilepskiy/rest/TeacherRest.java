package ru.prilepskiy.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.dto.TeacherDto;
import ru.prilepskiy.dto.search.TeacherSearchCriteria;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.service.TeacherService;

import java.util.Set;

@RestController
@RequestMapping("/teacher")
public class TeacherRest {

    private TeacherService teacherService;

    public TeacherRest(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(path = "/echo")
    public String echo() {
        return "echo";
    }

    @GetMapping(path = "/{id}")
    public TeacherEntity getId(@PathVariable int id) {
        return this.teacherService.findById(id);
    }

    @PostMapping(path = "/search")
    public Set<TeacherDto> search(TeacherSearchCriteria criteria) {
        return this.teacherService.findTeacherByQueryDsl(criteria);
    }

    @PostMapping(path = "/searchSpec")
    public Set<TeacherDto> searSpec(TeacherSearchCriteria criteria) {
        return this.teacherService.findTeacherBySpecification(criteria);
    }
}
