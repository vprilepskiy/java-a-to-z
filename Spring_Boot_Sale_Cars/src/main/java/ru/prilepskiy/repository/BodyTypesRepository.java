package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.entity.BodyTypesEntity;

public interface BodyTypesRepository extends CrudRepository<BodyTypesEntity, Integer> {
}
