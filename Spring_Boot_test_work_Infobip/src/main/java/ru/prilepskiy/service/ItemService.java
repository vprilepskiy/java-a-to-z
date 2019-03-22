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


    public ItemsEntity addItem(Principal principal, int markId, int modelId, int bodyTypeId, int year, int price) {
        UserEntity user = this.userRepository.findFirstByLogin(principal.getName());

        ItemsEntity item = new ItemsEntity();
        item.setUser(user);

        // добавить объявление
        return this.itemRepository.save(item);
    }
}
