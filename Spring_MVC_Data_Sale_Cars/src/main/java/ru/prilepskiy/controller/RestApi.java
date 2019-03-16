package ru.prilepskiy.controller;

import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.MarksEntity;
import ru.prilepskiy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.service.MarkService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequestMapping("/api")
@RestController
public class RestApi {

    @Autowired
    ItemService itemService;

    @Autowired
    MarkService markService;

    @Deprecated
    @GetMapping("/a")
    public ResponseEntity a() {
        Iterable<ItemsEntity> all = this.itemService.findAll();
        List<ItemsEntity> result = StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Deprecated
    @GetMapping("/b")
    public ItemsEntity save() {
        return this.itemService.save();
    }


    @GetMapping("/Items")
    public List<ItemsEntity> getItems(boolean today, boolean withPhoto, int markId) {
        return this.itemService.getItems(today, withPhoto, markId);
    }

    @GetMapping("/Marks")
    public Iterable<MarksEntity> getMarks() {
        return this.markService.getMarks();
    }
}
