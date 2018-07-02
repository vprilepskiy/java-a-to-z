package ru.prilepskiy.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Резерв. Хранит записи созданные этим генератором транзакций.
 *
 *
 * Created by VLADIMIR on 21.05.2018.
 */


@Entity(name = "spc_gen_trz")
public class Transaction {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;

    @Id
    @GeneratedValue(generator = "db-uuid")
    @GenericGenerator(name = "db-uuid", strategy = "guid")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
