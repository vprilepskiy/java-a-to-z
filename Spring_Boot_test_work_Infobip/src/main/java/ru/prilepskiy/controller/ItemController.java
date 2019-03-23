package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.response.Register;
import ru.prilepskiy.service.ItemService;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ItemController {

    private String domainUrl = "http://short.com/";

    @Autowired
    ItemService itemService;

    @PostMapping("/register")
    public Register register(String url) {
        String idBase36 = this.itemService.saveOrUpdateAndGetId(url);
        return new Register(String.format("%s%s", this.domainUrl, idBase36));
    }

    @GetMapping("/statistic")
    public Map<String, Integer> statistic(String accountId) {
        Iterable<ItemsEntity> items = this.itemService.findItemsByUsername(accountId);
        Map<String, Integer> result = StreamSupport.stream(items.spliterator(), false)
                .collect(Collectors.toMap(item -> item.getUrl(), item -> item.getCount()));
        return result;
    }
}
