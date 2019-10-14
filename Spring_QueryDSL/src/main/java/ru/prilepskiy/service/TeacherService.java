package ru.prilepskiy.service;

import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;
import ru.prilepskiy.dto.TeacherDto;
import ru.prilepskiy.mapper.ObjectMapper;
import ru.prilepskiy.model.QTeacherEntity;
import ru.prilepskiy.model.SchoolClassEntity;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.repository.TeacherRepository;
import ru.prilepskiy.search.TeacherSearchCriteria;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeacherService {

    private TeacherRepository repository;
    private ObjectMapper mapper;

    public TeacherService(TeacherRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TeacherEntity findById(int id) {
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Set<TeacherDto> find(TeacherSearchCriteria criteria) {
        final BooleanBuilder where = new BooleanBuilder();

        if (criteria.getSchoolId() != null) {
            where.and(QTeacherEntity.teacherEntity.classes.any().school.id.eq(criteria.getSchoolId()));
        }

        if (criteria.getClassId() != null) {
            final SchoolClassEntity schoolClassEntity = new SchoolClassEntity();
            schoolClassEntity.setId(criteria.getClassId());
            where.and(QTeacherEntity.teacherEntity.classes.contains(schoolClassEntity));
        }

        if (criteria.getTeacherFirstName() != null) {
            where.and(QTeacherEntity.teacherEntity.firstName.contains(criteria.getTeacherFirstName()));
        }

        if (criteria.getTeacherMiddleName() != null) {
            where.and(QTeacherEntity.teacherEntity.middleName.contains(criteria.getTeacherFirstName()));
        }

        if (criteria.getTeacherLastName() != null) {
            where.and(QTeacherEntity.teacherEntity.lastName.contains(criteria.getTeacherLastName()));
        }

        if (criteria.getStudentFirstName() != null) {
            where.and(QTeacherEntity.teacherEntity.classes.any().students.any().firstName.contains(criteria.getStudentFirstName()));
        }

        if (criteria.getStudentMiddleName() != null) {
            where.and(QTeacherEntity.teacherEntity.classes.any().students.any().middleName.contains(criteria.getStudentMiddleName()));
        }

        if (criteria.getStudentLastName() != null) {
            where.and(QTeacherEntity.teacherEntity.classes.any().students.any().lastName.contains(criteria.getStudentLastName()));
        }

        Iterable<TeacherEntity> entities = this.repository.findAll(where);
        return StreamSupport.stream(entities.spliterator(), false).map(t -> mapper.toDto(t)).collect(Collectors.toSet());
    }
}
