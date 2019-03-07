package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.ModelsEntity;

public interface ModelsRepository extends CrudRepository<ModelsEntity, Integer> {
}
