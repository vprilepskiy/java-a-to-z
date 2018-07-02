package ru.prilepskiy.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.prilepskiy.domain.*;
import ru.prilepskiy.service.AddressService;
import ru.prilepskiy.service.CardService;
import ru.prilepskiy.service.P5ConfigService;
import ru.prilepskiy.service.TypeOfServiceService;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
@RequestMapping("/api")
@RestController
public class PreWebFormController {

    final Logger logger = Logger.getLogger(PreWebFormController.class);

    @Autowired
    AddressService addressService;

    @Autowired
    CardService cardService;

    @Autowired
    P5ConfigService p5ConfigService;

    @Autowired
    TypeOfServiceService typeOfServiceService;


//    /**
//     * Unused.
//     * @return - Все АЗС.
//     */
//    @GetMapping("/azs")
//    public Iterable<Address> getAzs() {
//        return this.addressService.get();
//    }
//
//    /**
//     * Unused.
//     * @return - Карта оператора.
//     */
//    @GetMapping("/operator_card")
//    public Card getOperatorCard() {
//        return this.cardService.getOperatorCard();
//    }
//
//    /**
//     * Unused.
//     * @return - Карта клиента.
//     */
//    @GetMapping("/client_card/{grNomer}")
//    public Card getClientCard(@PathVariable Long grNomer) {
//        return this.cardService.getClientCard(grNomer);
//    }
//
//    /**
//     * Unused.
//     * @param grNomer - номер карты.
//     * @return - Кошельки карты.
//     */
//    @GetMapping("/client_card_services/{grNomer}")
//    public Iterable<ru.prilepskiy.domain.CardService> getCardServicesByGrNomer(@PathVariable Long grNomer) {
//        return this.cardService.getCardServicesByGrNomer(grNomer);
//    }
//
//    /**
//     * Unused.
//     * @param grNomer - номер карты.
//     * @return - Виды топлива карты.
//     */
//    @GetMapping("/client_card_type_services/{grNomer}")
//    public Iterable<TypeOfService> getCardTypeOfServicesByGrNomer(@PathVariable Long grNomer) {
//        return this.cardService.getCardTypeOfServicesByGrNomer(grNomer);
//    }

    /**
     * Unused.
     * @param grNomer - номер карты.
     * @return - Клиент.
     */
    @GetMapping("/client/{grNomer}")
    public Client getClientByGrNomer(@PathVariable Long grNomer) {
        return this.cardService.getClientByGrNomer(grNomer);
    }

    /**
     * Unused.
     * @return - Эмитент.
     */
    @GetMapping("/p5config")
    public P5Config getP5Config() {
        return this.p5ConfigService.getP5Config();
    }
//
//    /**
//     * Unused.
//     * @return - Все виды топлива.
//     */
//    @GetMapping("/services")
//    public Iterable<TypeOfService> getAllTypeOfServices() {
//        return this.typeOfServiceService.getAll();
//    }


    @GetMapping("/getDataForm")
    public Object getDataForm() {

        return new Object() {

            public Iterable<Address> getAzs() {
                return addressService.get();
            };

            public P5Config getP5Config() {
                return p5ConfigService.getP5Config();
            };

            public Card getOperatorCard() {
                return cardService.getOperatorCard();
            }
        };
    }
}
