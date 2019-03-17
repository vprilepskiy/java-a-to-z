package ru.prilepskiy.service;

import ru.prilepskiy.entity.BodyTypesEntity;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.MarksEntity;
import ru.prilepskiy.entity.ModelsEntity;
import ru.prilepskiy.repository.BodyTypesRepository;
import ru.prilepskiy.repository.ItemRepository;
import ru.prilepskiy.repository.ItemRepositoryCustom;
import ru.prilepskiy.repository.MarksRepository;
import ru.prilepskiy.repository.ModelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
//@Repository
@Transactional
//@Lazy
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemRepositoryCustom itemRepositoryCustom;

    @Autowired
    MarksRepository marksRepository;

    @Autowired
    ModelsRepository modelsRepository;

    @Autowired
    BodyTypesRepository bodyTypesRepository;

    public ItemsEntity findById(int id) {
        return this.itemRepository.findById(id).get();
    }

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

    /**
     * Add photo in Item.
     *
     * @param photo - photo(int id, photo byte[])
     */
    public ItemsEntity updatePhoto(ItemsEntity photo) {
        ItemsEntity item = this.itemRepository.findById(photo.getId()).get();
        item.setPhoto(photo.getPhoto());
        return this.itemRepository.save(item);
    }

    /**
     * Add item.
     *
     * @param markId      - id mark.
     * @param modelId     - id model.
     * @param bodyTypeId  - id body type.
     * @param year        - year.
     * @param price       - price.
     */
    public ItemsEntity addItem(int markId, int modelId, int bodyTypeId, int year, int price) {
        MarksEntity mark = this.marksRepository.findById(markId).get();
        ModelsEntity model = this.modelsRepository.findById(modelId).get();
        BodyTypesEntity bodyType = this.bodyTypesRepository.findById(bodyTypeId).get();

        ItemsEntity item = new ItemsEntity();
        item.setMark(mark);
        item.setModel(model);
        item.setBodyType(bodyType);
        item.setYear(year);
        item.setPrice(price);
        item.setActive(true);
        item.setCreated(new Timestamp(System.currentTimeMillis()));

        // добавить объявление
        return this.itemRepository.save(item);
    }

    /**
     * Set active parameter.
     * @param itemId - id item.
     * @param state - parameter.
     */
    public ItemsEntity setActive(int itemId, boolean state) {
        ItemsEntity item = this.itemRepository.findById(itemId).get();
        item.setActive(state);
        return item;
    }

    /**
     * Get items by condition.
     * @param today - only today.
     * @param withPhoto - only with Photo.
     * @param markId - on mark Id.
     * @return - items.
     */
    public List<ItemsEntity> getItems(boolean today, boolean withPhoto, int markId, boolean active) {
        return this.itemRepositoryCustom.getItems(today, withPhoto, markId, active);
    }

}
