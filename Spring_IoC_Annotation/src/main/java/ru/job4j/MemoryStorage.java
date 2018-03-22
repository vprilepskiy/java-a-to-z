package ru.job4j;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
@Component
public class MemoryStorage implements IStorage {

    @Override
    public void add(User user) {
        System.out.println("store to memory");
    }


    @Description("Выполнится при создании бина")
    @PostConstruct
    public void beanInit() {
        System.out.printf("Init bean: %s \n", this.getClass().getName());
    }


    @Description("Выполнится при уничтожении бина")
    @PreDestroy
    public void beanDestroy() {
        System.out.printf("Destroy bean: %s \n", this.getClass().getName());
    }
}
