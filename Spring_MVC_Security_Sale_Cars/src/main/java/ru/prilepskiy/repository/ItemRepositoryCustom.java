package ru.prilepskiy.repository;

import ru.prilepskiy.entity.ItemsEntity;

import java.util.List;

public interface ItemRepositoryCustom {

    List<ItemsEntity> getItems(boolean today, boolean withPhoto, int markId, boolean active, boolean onlyMy);

}
