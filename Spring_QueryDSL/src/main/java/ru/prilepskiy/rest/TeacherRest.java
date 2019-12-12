package ru.prilepskiy.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.dto.TeacherDto;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.search.TeacherSearchCriteria;
import ru.prilepskiy.service.TeacherService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        return this.teacherService.find(criteria);
    }

    @PostMapping(path = "/searchSpec")
    public List<TeacherEntity> searSpec(TeacherSearchCriteria criteria) {
        List<TeacherEntity> spec = this.teacherService.findSpec(criteria);
        return spec;
    }
}
