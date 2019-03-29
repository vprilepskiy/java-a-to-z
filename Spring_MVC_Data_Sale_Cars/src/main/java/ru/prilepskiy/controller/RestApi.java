package ru.prilepskiy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import ru.prilepskiy.entity.BodyTypesEntity;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.MarksEntity;
import ru.prilepskiy.service.BobyTypeService;
import ru.prilepskiy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.service.MarkService;

import java.util.List;
@RequestMapping("/api")
@RestController
public class RestApi {

    @Autowired
    private ItemService itemService;

    @Autowired
    private MarkService markService;

    @Autowired
    private BobyTypeService bobyTypeService;

    @GetMapping("/Items")
    public List<ItemsEntity> getItems(boolean today, boolean withPhoto, int markId, boolean active) {
        return this.itemService.getItems(today, withPhoto, markId, active);
    }

    @GetMapping("/Marks")
    public Iterable<MarksEntity> getMarks() {
        return this.markService.getMarks();
    }

    @GetMapping("/BodyTypes")
    public Iterable<BodyTypesEntity> getBodyTypes() {
        return this.bobyTypeService.getBodyTapes();
    }

    @PostMapping("/Item")
    public ItemsEntity addItem(int markId, int modelId, int bodyTypeId, int year, int price) {
        return this.itemService.addItem(markId, modelId, bodyTypeId, year, price);
    }

    @PostMapping("/SetStateItem")
    public ItemsEntity setActive(int itemId, boolean state) {
        return this.itemService.setActive(itemId, state);
    }

    @PostMapping("/FileUpload")
    public ItemsEntity updatePhoto(ItemsEntity photo) {
        return this.itemService.updatePhoto(photo);
    }
}
