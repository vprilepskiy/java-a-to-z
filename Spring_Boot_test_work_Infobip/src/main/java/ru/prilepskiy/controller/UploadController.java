package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.service.ItemService;

import java.io.IOException;


@RequestMapping("/api/io")
@RestController
public class UploadController {

    @Autowired
    ItemService itemService;

    @PostMapping("/upload")
    public ItemsEntity singleFileUpload(Integer itemId, MultipartFile[] files) {
        ItemsEntity item = new ItemsEntity();
        if (files.length > 0) {
            try {
                item.setId(itemId);
                item.setPhoto(files[0].getBytes());
                item = this.itemService.updatePhoto(item);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return item;
    }
}
