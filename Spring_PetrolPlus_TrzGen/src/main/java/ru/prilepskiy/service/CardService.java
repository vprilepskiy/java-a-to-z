package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prilepskiy.domain.Card;
import ru.prilepskiy.domain.Client;
import ru.prilepskiy.domain.TypeOfService;
import ru.prilepskiy.repository.CardRepository;
import ru.prilepskiy.repository.CardServiceRepository;
import ru.prilepskiy.repository.ClientRepository;
import ru.prilepskiy.repository.TypeOfServiceRepository;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Карты и кошельки карт.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardServiceRepository cardServiceRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TypeOfServiceRepository typeOfServiceRepository;

    /**
     * Вернет первую попавшуюся карту оператора.
     * @return
     */
    public Card getOperatorCard() {
        return this.cardRepository.findFirstByTipKarty(TipKarty.OPERATOR.index());
    }

    /**
     * Вернет карту клиента по номеру.
     * @param grNomer
     * @return
     */
    public Card getClientCard(long grNomer) {
        return this.cardRepository.findFirstByTipKartyAndIdPrinadlejnostiAndGrNomer(TipKarty.CLIENT.index(), IdPrinadlejnosti.FIRMA.index(), grNomer);
    }

    /**
     * Вернет кошельки карт по grNomer.
     * @param grNomer
     * @return
     */
    public Iterable<ru.prilepskiy.domain.CardService> getCardServicesByGrNomer(long grNomer) {
        Iterable<ru.prilepskiy.domain.CardService> cardServices = null;
        Card card = this.getClientCard(grNomer);
        if (card != null) {
            cardServices = this.cardServiceRepository.findByIdKarty(card.getIdKarty());
        }
        return cardServices;
    }

    /**
     * Верент виды топлива по grNomer.
     * @param grNomer
     * @param isCurrency - true если нужны валютные кошельки, false - если нужны невалютные кошельки.
     * @return
     */
    public List<TypeOfService> getCardTypeOfServicesByGrNomer(long grNomer, boolean isCurrency) {
        List<TypeOfService> typeOfServices = new LinkedList<>();
        for(ru.prilepskiy.domain.CardService cardService : this.getCardServicesByGrNomer(grNomer)) {
            typeOfServices.add(this.typeOfServiceRepository.findFirstByIdUslugiAndActivnostAndCurrency(cardService.getIdKoshelka(), true, isCurrency));
        }
        return typeOfServices;
    }

    /**
     * Верент виды топлива по grNomer.
     * @param grNomer
     * @return
     */
    public List<TypeOfService> getCardTypeOfServicesByGrNomer(long grNomer) {
        List<TypeOfService> typeOfServices = new LinkedList<>();
        for(ru.prilepskiy.domain.CardService cardService : this.getCardServicesByGrNomer(grNomer)) {
            typeOfServices.add(this.typeOfServiceRepository.findOne(cardService.getIdKoshelka()));
        }
        return typeOfServices;
    }

    /**
     * Вернет клиента по grNomer.
     * @param grNomer
     * @return
     */
    public Client getClientByGrNomer(long grNomer) {
        Client client = null;
        Card card = this.getClientCard(grNomer);
        if (card != null) {
            client = this.clientRepository.findOne(card.getIdVladeltza());
        }
        return client;
    }

    /**
     * Проверит. Есть ли валютный кошелек на карте.
     * @param grNomer
     * @return - true если есть валютный кошелек, false если нет валютного кошелька.
     */
    public boolean isCurrency(long grNomer) {
        boolean result = false;
        for(TypeOfService typeOfService : this.getCardTypeOfServicesByGrNomer(grNomer)) {
            if (typeOfService.isCurrency()) {
                result = true;
                break;
            }
        }
        return result;
    }


    /**
     * Найдет услуги - за что.
     * Если есть валютный кошелек на карте, то показать все услуги, кроме валютных.
     * Если нет валютного кошелька на карте, то показать только те услуги которые есть на карте, кроме валютных.
     * @param grNomer
     * @return
     */
    public Iterable<TypeOfService> productForWhat(long grNomer) {
        Iterable<TypeOfService> typeOfServices;
        if (this.isCurrency(grNomer)) {
            typeOfServices = this.typeOfServiceRepository.findByActivnostAndCurrency(true, false);
        } else {
            typeOfServices = this.getCardTypeOfServicesByGrNomer(grNomer, false);
        }
        return typeOfServices;
    }

    /**
     * Найдет услуги чем.
     * @param grNomer
     * @return
     */
    public List<TypeOfService> productThan(long grNomer) {
        return this.getCardTypeOfServicesByGrNomer(grNomer);
    }




    /**
     * Типы карт.
     */
    enum TipKarty {
        CLIENT(1),
        OPERATOR(2),
        ADMINISTRATOR(3),
        INCAS(4),
        SERVICE(5),
        TRANSACTIONAL(6),
        STOP_LIST(7),
        ATP_OPERATOR(9);

        private final int index;

        TipKarty(int index) {
            this.index = index;
        }

        public int index() {
            return index;
        }
    }

    enum IdPrinadlejnosti {

        PERSONAL(1),
        FIRMA(2),
        CHASTNOE_LITSO(3),
        TERMINALS(7),
        TOCHKA_OBSL(8),
        EMITENTS(9);

        private final int index;

        IdPrinadlejnosti(int index) {
            this.index = index;
        }

        public int index() {
            return index;
        }
    }

}
