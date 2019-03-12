package ru.prilepskiy.repository;

import ru.prilepskiy.entity.ItemsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemsEntity, Integer> {
}
