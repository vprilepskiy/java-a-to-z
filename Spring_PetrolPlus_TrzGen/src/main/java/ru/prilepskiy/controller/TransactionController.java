package ru.prilepskiy.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.prilepskiy.service.TransactionService;

import java.math.BigDecimal;


/**
 * Created by VLADIMIR on 29.05.2018.
 */
@RequestMapping("/api")
@RestController
public class TransactionController {

    final Logger logger = Logger.getLogger(TransactionController.class);

    @Autowired
    TransactionService transactionService;

    @PostMapping("/addTransaction")
    public boolean addTransaction(@RequestParam("device") long idTochkiObslugivaniya,
                                 @RequestParam("type_operation") long operatziya,
                                 @RequestParam("date") long dataZapisi,
                                 @RequestParam("time") String time,
                                 @RequestParam("card_emitent") long card_emitent,
                                 @RequestParam("card_number") long card_number,
                                 @RequestParam("product_for_what") long product_for_what,
                                 @RequestParam("product_than") long product_than,
                                 @RequestParam("amount_for_what") BigDecimal amount_for_what,
                                 @RequestParam("amount_than") BigDecimal amount_than,
                                 @RequestParam("service_card") long service_card) {

        this.logger.info(idTochkiObslugivaniya);
        this.logger.info(operatziya);
        this.logger.info(new java.sql.Date(dataZapisi));
        this.logger.info(time);
        this.logger.info(card_emitent);
        this.logger.info(card_number);
        this.logger.info(product_for_what);
        this.logger.info(product_than);
        this.logger.info(amount_for_what);
        this.logger.info(amount_than);
        this.logger.info(service_card);

        return this.transactionService.add(
                idTochkiObslugivaniya,
                operatziya,
                dataZapisi,
                time,
                card_emitent,
                card_number,
                product_for_what,
                product_than,
                amount_for_what,
                amount_than,
                service_card);
    }
}
