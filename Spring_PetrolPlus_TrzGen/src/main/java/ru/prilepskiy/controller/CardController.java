package ru.prilepskiy.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.prilepskiy.domain.Client;
import ru.prilepskiy.domain.TransactionLocal;
import ru.prilepskiy.domain.TypeOfService;
import ru.prilepskiy.service.CardService;
import ru.prilepskiy.service.TransactionLocalService;

import java.util.Date;

/**
 * Created by VLADIMIR on 28.05.2018.
 */

@RequestMapping("/api")
@RestController
public class CardController {

    final Logger logger = Logger.getLogger(CardController.class);

    @Autowired
    CardService cardService;

    @Autowired
    TransactionLocalService transactionLocalService;


    /**
     * По номеру карты вернуть несколько параметров.
     * @param grNomer - номер карты.
     * @return - Виды топлива карты (Чем, За что), Клинет, последние транзакции.
     */
    @GetMapping("/card_services_and_client/{grNomer}")
    public Object getTypeOfServicesAndClientByGrNomer(@PathVariable Long grNomer) {

        return new Object() {

            public Iterable<TypeOfService> getForWhat() {
                return cardService.productForWhat(grNomer);
            };

            public Iterable<TypeOfService> getThan() {
                return cardService.productThan(grNomer);
            };

            public Client getClient() {
                return cardService.getClientByGrNomer(grNomer);
            };
        };
    }


    /**
     * По номеру карты вернуть несколько параметров.
     * @param grNomer - номер карты.
     * @return - Виды топлива карты (Чем, За что), Клинет, последние транзакции.
     */
    @GetMapping("/transactions/{grNomer}")
    public Iterable<TransactionLocal> getTransactionsLocalClientByGrNomer(@PathVariable Long grNomer, @RequestParam("dateTrz") long dateTrz, @RequestParam("periodLastDaysTrz") long periodLastDaysTrz) {

        final java.sql.Date startDate = new java.sql.Date(dateTrz  + (periodLastDaysTrz * 1000 * 60 * 60 * 24));
        final java.sql.Date endDate = new java.sql.Date(dateTrz - (periodLastDaysTrz * 1000 * 60 * 60 * 24));

        return transactionLocalService.findByDataBetweenAndGrNomer(endDate, startDate, grNomer);
    }

}
