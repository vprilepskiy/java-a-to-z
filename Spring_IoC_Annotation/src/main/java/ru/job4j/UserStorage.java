package ru.job4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
@Component
@Description("description")
public class UserStorage {

    /**
     * iStorage.
     */
    private IStorage iStorage;

    public UserStorage() {
    }

    /**
     * Constructor.
     * @param iStorage - iStorage.
     */
    @Autowired
    public UserStorage(@Qualifier("memoryStorage") IStorage iStorage) {
        this.iStorage = iStorage;
    }

    /**
     * Add user.
     * @param user - user.
     */
    public void add(User user) {
        this.iStorage.add(user);
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
