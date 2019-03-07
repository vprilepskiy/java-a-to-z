package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prilepskiy.domain.BodyTypesEntity;
import ru.prilepskiy.domain.ItemsEntity;
import ru.prilepskiy.domain.MarksEntity;
import ru.prilepskiy.domain.ModelsEntity;
import ru.prilepskiy.repository.BodyTypesRepository;
import ru.prilepskiy.repository.ItemRepository;
import ru.prilepskiy.repository.MarksRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.StreamSupport;

@Service
//@Repository
@Transactional
//@Lazy
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MarksRepository marksRepository;

    @Autowired
    BodyTypesRepository bodyTypesRepository;

    public Iterable<ItemsEntity> findAll() {
        return this.itemRepository.findAll();
    }

    public ItemsEntity save() {
        ItemsEntity itemsEntity = new ItemsEntity();

        MarksEntity marksEntity = StreamSupport.stream(this.marksRepository.findAll().spliterator(), false).findFirst().get();
        BodyTypesEntity bodyTypesEntity = StreamSupport.stream(this.bodyTypesRepository.findAll().spliterator(), false).findFirst().get();

        bodyTypesEntity.setDescription("Crossover");

        itemsEntity.setMark(new MarksEntity(marksEntity.getId()));
        itemsEntity.setModel(marksEntity.getModels().stream().findFirst().get());
        itemsEntity.setBodyType(bodyTypesEntity);
        itemsEntity.setYear(2000);
        itemsEntity.setPrice(250000);
        itemsEntity.setActive(true);
        itemsEntity.setCreated(new Timestamp(new Date().getTime()));
        return this.itemRepository.save(itemsEntity);
    }

}
