package ru.prilepskiy.service;

import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;
import ru.prilepskiy.model.QTeacherEntity;
import ru.prilepskiy.model.SchoolClassEntity;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.repository.TeacherRepository;
import ru.prilepskiy.search.TeacherSearchCriteria;

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

        return this.repository.findAll(where);
    }
}
