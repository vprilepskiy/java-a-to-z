package ru.prilepskiy.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.search.TeacherSearchCriteria;

public class TeacherSpecification {

    public static Specification<TeacherEntity> byCriteria(TeacherSearchCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("firstName"), criteria.getTeacherFirstName());
    }

}
