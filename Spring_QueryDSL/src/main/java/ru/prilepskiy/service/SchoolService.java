package ru.prilepskiy.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.stereotype.Service;
import ru.prilepskiy.model.QSchoolEntity;
import ru.prilepskiy.model.QStudentEntity;
import ru.prilepskiy.model.SchoolEntity;
import ru.prilepskiy.repository.SchoolDslRepository;
import ru.prilepskiy.repository.SchoolJpaRepository;

@Deprecated
@Service
public class SchoolService {

    public SchoolService(SchoolDslRepository schoolDslRepository, SchoolJpaRepository schoolJpaRepository) {
        this.schoolDslRepository = schoolDslRepository;
        this.schoolJpaRepository = schoolJpaRepository;
    }

    private final SchoolDslRepository schoolDslRepository;
    private final SchoolJpaRepository schoolJpaRepository;

    public int dsl() {
        return schoolDslRepository.findAll().size();
    }

    public int jpa() {
        return schoolJpaRepository.findAll().size();
    }

    public int jpa1() {
        return schoolJpaRepository.findAll().size();
    }

}
