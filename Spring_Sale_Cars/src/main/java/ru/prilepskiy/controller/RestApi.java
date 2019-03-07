package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.domain.ItemsEntity;
import ru.prilepskiy.repository.defaultData.AddEnums;
import ru.prilepskiy.service.ItemService;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api")
@RestController
public class RestApi {

    @Autowired
    ItemService itemService;

    @GetMapping("/a")
    public Iterable<ItemsEntity> a() {
        Iterable<ItemsEntity> all = this.itemService.findAll();
        return this.itemService.findAll();
    }

    @GetMapping("/b")
    public ItemsEntity save() {
        return this.itemService.save();
    }
}
