package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.service.ItemService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping("/Items.skip")
    public List<ItemsEntity> getItems(boolean today, boolean withPhoto, int markId, boolean active, boolean onlyMy) {
        return null;
    }

    @PostMapping("/Item")
    public ItemsEntity addItem(Principal principal, int markId, int modelId, int bodyTypeId, int year, int price) {
        return null;
    }
}
