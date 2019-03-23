package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.UserEntity;

public interface ItemRepository extends CrudRepository<ItemsEntity, Integer> {

    ItemsEntity findFirstByUrlAndRedirectTypeAndUser(String url, Integer redirectType, UserEntity user);

}
