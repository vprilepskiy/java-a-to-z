package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.UserEntity;
import ru.prilepskiy.helper.Utils;
import ru.prilepskiy.repository.ItemRepository;
import ru.prilepskiy.repository.UserRepository;

import java.security.Principal;

@Service
@Transactional
public class ItemService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    Utils utils;

    public String saveOrUpdateAndGetId(String url) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = this.userRepository.findFirstByUsername(principal.getName());
        ItemsEntity item = this.itemRepository.findFirstByUrlAndUser(url, user);
        if (item != null) {
            item.setCount(Math.incrementExact(item.getCount()));
            item = this.itemRepository.save(item);
        } else {
            item = new ItemsEntity();
            item.setUrl(url);
            item.setUser(user);
            item.setCount(1);
            item = this.itemRepository.save(item);
        }
        return this.utils.toBase36(item.getId());
    }

    public Iterable<ItemsEntity> findItemsByUsername(String username) {
        UserEntity user = this.userRepository.findFirstByUsername(username);
        return this.itemRepository.findByUser(user);
    }
}
