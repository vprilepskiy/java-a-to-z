package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.entity.MarksEntity;


public interface MarksRepository extends CrudRepository<MarksEntity, Integer> {
}
