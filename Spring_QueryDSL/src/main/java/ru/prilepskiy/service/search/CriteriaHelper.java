package ru.prilepskiy.service.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import ru.prilepskiy.dto.search.TeacherSearchCriteria;
import ru.prilepskiy.model.QTeacherEntity;
import ru.prilepskiy.model.SchoolClassEntity;

import java.util.Optional;

public class CriteriaHelper {

    public static Predicate toPredicate(TeacherSearchCriteria criteria) {
        final BooleanBuilder where = new BooleanBuilder();

        Optional.ofNullable(criteria.getSchoolId())
            .ifPresent(id -> where.and(QTeacherEntity.teacherEntity.classes.any().school.id.eq(id)));

        Optional.ofNullable(criteria.getClassId()).ifPresent(id -> {
            final SchoolClassEntity v = new SchoolClassEntity();
            v.setId(id);
            where.and(QTeacherEntity.teacherEntity.classes.contains(v));
        });

        Optional.ofNullable(criteria.getTeacherFirstName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.firstName.contains(v)));

        Optional.ofNullable(criteria.getTeacherMiddleName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.middleName.contains(v)));

        Optional.ofNullable(criteria.getTeacherLastName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.lastName.contains(v)));

        Optional.ofNullable(criteria.getStudentFirstName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.classes.any().students.any().firstName.contains(v)));

        Optional.ofNullable(criteria.getStudentMiddleName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.classes.any().students.any().middleName.contains(v)));

        Optional.ofNullable(criteria.getStudentLastName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.classes.any().students.any().lastName.contains(v)));

        return where;
    }

}
