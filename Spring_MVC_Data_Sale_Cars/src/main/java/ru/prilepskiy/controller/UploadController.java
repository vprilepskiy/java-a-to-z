package ru.prilepskiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.service.ItemService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by VLADIMIR on 16.03.2019.
 */

@RequestMapping("/api/io")
@RestController
public class UploadController {

    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

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
