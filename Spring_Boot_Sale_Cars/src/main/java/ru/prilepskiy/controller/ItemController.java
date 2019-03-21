package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.entity.BodyTypesEntity;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.MarksEntity;
import ru.prilepskiy.service.BobyTypeService;
import ru.prilepskiy.service.ItemService;
import ru.prilepskiy.service.MarkService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    MarkService markService;

    @Autowired
    BobyTypeService bobyTypeService;

    @GetMapping("/Items.skip")
    public List<ItemsEntity> getItems(boolean today, boolean withPhoto, int markId, boolean active, boolean onlyMy) {
        return this.itemService.getItems(today, withPhoto, markId, active, onlyMy);
    }

    @GetMapping("/Marks.skip")
    public Iterable<MarksEntity> getMarks() {
        return this.markService.getMarks();
    }

    @GetMapping("/BodyTypes.skip")
    public Iterable<BodyTypesEntity> getBodyTypes() {
        return this.bobyTypeService.getBodyTapes();
    }

    @PostMapping("/Item")
    public ItemsEntity addItem(Principal principal, int markId, int modelId, int bodyTypeId, int year, int price) {
        return this.itemService.addItem(principal, markId, modelId, bodyTypeId, year, price);
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
