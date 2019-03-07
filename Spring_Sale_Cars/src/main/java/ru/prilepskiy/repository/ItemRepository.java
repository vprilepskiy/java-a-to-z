package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.ItemsEntity;

public interface ItemRepository extends CrudRepository<ItemsEntity, Integer> {
}
