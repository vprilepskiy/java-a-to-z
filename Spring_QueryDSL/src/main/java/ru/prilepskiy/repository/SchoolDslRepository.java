package ru.prilepskiy.repository;

import org.springframework.stereotype.Repository;
import ru.prilepskiy.model.SchoolEntity;

@Repository
public interface SchoolDslRepository extends QueryDslRepository<SchoolEntity, Integer>  {
}
