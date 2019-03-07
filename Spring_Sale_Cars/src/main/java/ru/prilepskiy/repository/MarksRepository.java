package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.MarksEntity;

public interface MarksRepository extends CrudRepository<MarksEntity, Integer> {
}
