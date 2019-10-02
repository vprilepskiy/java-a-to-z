package ru.prilepskiy.service;

import com.mysema.query.jpa.JPASubQuery;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Service;
import ru.prilepskiy.model.QSchoolClassEntity;
import ru.prilepskiy.model.QSchoolEntity;
import ru.prilepskiy.model.QTeacherEntity;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.repository.TeacherRepository;
import ru.prilepskiy.search.TeacherSearchCriteria;

import java.util.Optional;

@Service
public class TeacherService {

    private TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public TeacherEntity findById(int id) {
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Iterable<TeacherEntity> find(TeacherSearchCriteria criteria) {
        BooleanExpression teacherFirstName = QTeacherEntity.teacherEntity.firstName.contains(criteria.getTeacherFirstName());
        BooleanExpression schoolId = QTeacherEntity.teacherEntity.classes.any().school.id.eq(criteria.getClassId());
        return this.repository.findAll(teacherFirstName.and(schoolId));
    }
}
