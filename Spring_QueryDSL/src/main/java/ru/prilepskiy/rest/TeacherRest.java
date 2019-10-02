package ru.prilepskiy.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.search.TeacherSearchCriteria;
import ru.prilepskiy.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherRest {

    private TeacherService teacherService;

    public TeacherRest(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(path = "/{id}")
    public TeacherEntity getId(@PathVariable int id) {
        return this.teacherService.findById(id);
    }

    @PostMapping(path = "/search")
    public Iterable<TeacherEntity> search(TeacherSearchCriteria criteria) {
        return this.teacherService.find(criteria);
    }


}
