package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Qualifier;
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
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    @Qualifier("itemRepositoryCustomJdbcImpl")
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
