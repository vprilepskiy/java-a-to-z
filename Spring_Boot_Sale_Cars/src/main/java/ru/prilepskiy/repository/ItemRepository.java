package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.entity.ItemsEntity;

public interface ItemRepository extends CrudRepository<ItemsEntity, Integer> {
}
