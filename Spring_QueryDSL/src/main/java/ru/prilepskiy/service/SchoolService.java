package ru.prilepskiy.service;

import org.springframework.stereotype.Service;
import ru.prilepskiy.model.SchoolEntity;
import ru.prilepskiy.repository.QueryDslRepository;
import ru.prilepskiy.repository.SchoolDslRepository;
import ru.prilepskiy.repository.SchoolJpaRepository;
import ru.prilepskiy.repository.SimpleJpaRepository;

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

}
