package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.UserEntity;
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

    public ItemsEntity saveOrUpdate(String url, Integer redirectType) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = this.userRepository.findFirstByUsername(principal.getName());
        ItemsEntity findItem = this.itemRepository.findFirstByUrlAndRedirectTypeAndUser(url, redirectType, user);
        if (findItem != null) {
            findItem.setCount(Math.incrementExact(findItem.getCount()));
            return this.itemRepository.save(findItem);
        } else {
            ItemsEntity item = new ItemsEntity();
            item.setUrl(url);
            item.setRedirectType(redirectType);
            item.setUser(user);
            item.setCount(1);
            return this.itemRepository.save(item);
        }
    }
}
