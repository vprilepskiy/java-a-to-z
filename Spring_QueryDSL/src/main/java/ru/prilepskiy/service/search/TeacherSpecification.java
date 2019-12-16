package ru.prilepskiy.service.search;

import org.springframework.data.jpa.domain.Specification;
import ru.prilepskiy.dto.search.TeacherSearchCriteria;
import ru.prilepskiy.model.SchoolClassEntity;
import ru.prilepskiy.model.SchoolClassEntity_;
import ru.prilepskiy.model.SchoolEntity;
import ru.prilepskiy.model.SchoolEntity_;
import ru.prilepskiy.model.StudentEntity;
import ru.prilepskiy.model.StudentEntity_;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.model.TeacherEntity_;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.SetJoin;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherSpecification {

    public static Specification<TeacherEntity> byCriteria(TeacherSearchCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            final SetJoin<TeacherEntity, SchoolClassEntity> classJoin = root.join(TeacherEntity_.classes, JoinType.LEFT);
            final SetJoin<SchoolClassEntity, StudentEntity> studentJoin = classJoin.join(SchoolClassEntity_.students, JoinType.LEFT);

            Optional.ofNullable(criteria.getClassId()).ifPresent(id -> {
                predicates.add(criteriaBuilder.equal(classJoin.get(SchoolClassEntity_.ID), id));
            });

            Optional.ofNullable(criteria.getSchoolId()).ifPresent(id -> {
                Join<SchoolClassEntity, SchoolEntity> schoolJoin = classJoin.join(SchoolClassEntity_.school, JoinType.LEFT);
                predicates.add(criteriaBuilder.equal(schoolJoin.get(SchoolEntity_.ID), id));
            });

            Optional.ofNullable(criteria.getTeacherFirstName())
                .ifPresent(v -> predicates.add(criteriaBuilder.like(root.get(TeacherEntity_.FIRST_NAME), v)));

            Optional.ofNullable(criteria.getTeacherMiddleName())
                .ifPresent(v -> predicates.add(criteriaBuilder.like(root.get(TeacherEntity_.MIDDLE_NAME), v)));

            Optional.ofNullable(criteria.getTeacherLastName())
                .ifPresent(v -> predicates.add(criteriaBuilder.like(root.get(TeacherEntity_.LAST_NAME), v)));

            Optional.ofNullable(criteria.getStudentFirstName())
                .ifPresent(v -> predicates.add(criteriaBuilder.equal(studentJoin.get(StudentEntity_.FIRST_NAME), v)));

            Optional.ofNullable(criteria.getStudentMiddleName())
                .ifPresent(v -> predicates.add(criteriaBuilder.equal(studentJoin.get(StudentEntity_.MIDDLE_NAME), v)));

            Optional.ofNullable(criteria.getStudentLastName())
                .ifPresent(v -> predicates.add(criteriaBuilder.equal(studentJoin.get(StudentEntity_.LAST_NAME), v)));

            criteriaQuery.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
