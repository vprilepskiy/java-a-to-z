package ru.prilepskiy.repository;

import ru.prilepskiy.entity.MarksEntity;
import org.springframework.data.repository.CrudRepository;


public interface MarksRepository extends CrudRepository<MarksEntity, Integer> {
}
