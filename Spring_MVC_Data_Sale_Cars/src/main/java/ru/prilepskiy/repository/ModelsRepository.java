package ru.prilepskiy.repository;

import ru.prilepskiy.entity.ModelsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ModelsRepository extends CrudRepository<ModelsEntity, Integer> {
}
