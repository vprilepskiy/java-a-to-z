package ru.prilepskiy.repository;

import org.springframework.stereotype.Repository;
import ru.prilepskiy.model.SchoolEntity;

@Repository
public interface SchoolJpaRepository extends SpringJpaRepository<SchoolEntity, Integer> {
}
