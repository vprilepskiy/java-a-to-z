package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prilepskiy.domain.TransactionInbox;
import ru.prilepskiy.domain.TransactionStorage;
import ru.prilepskiy.repository.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Добавить транзакцию в корзину и необработанные.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Service
public class TransactionService {

    @Autowired
    P5ConfigRepository p5ConfigRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionInboxRepository transactionInboxRepository;

    @Autowired
    TransactionStorageRepository transactionStorageRepository;

    @Autowired
    PersonnelRepository personnelRepository;

    @Autowired
    TerminalRepository terminalRepository;


    /**
     * Добавить транзакцию в корзину и необработанные.
     * @param idTochkiObslugivaniya
     * @param operatziya
     * @param dataZapisi
     * @param time
     * @param card_emitent
     * @param card_number
     * @param product_for_what
     * @param product_than
     * @param amount_for_what
     * @param amount_than
     * @param service_card
     */
    @Transactional
    public boolean add(long idTochkiObslugivaniya, long operatziya, long dataZapisi, String time, long card_emitent, long card_number, long product_for_what, long product_than, BigDecimal amount_for_what, BigDecimal amount_than, long service_card) {

        final long myEmitent = this.p5ConfigRepository.findFirstByOrderByIdEmitentAsc().getIdEmitent();
        final long elektrNomerTerminala = this.terminalRepository.findFirstByIdEmitentAndIdFilialAndIdTo(myEmitent, 0, idTochkiObslugivaniya).getNomerTerminala();

        // сохранить в необработанные
        final TransactionInbox transactionInbox = new TransactionInbox();
        transactionInbox.setDataZapisi(new java.sql.Date(new Date().getTime()));
        transactionInbox.setVremyaZapisi(0);
        transactionInbox.setData(new java.sql.Date(dataZapisi));
        transactionInbox.setVremya(this.parseTime(time));
        transactionInbox.setEmitentVladelKarti(card_emitent);
        transactionInbox.setGrNomer(card_number);
        transactionInbox.setTypeTr(0);
        transactionInbox.setEmGdeObsl(myEmitent);
        transactionInbox.setNomerKoshZaChtoPlatili(product_for_what);
        transactionInbox.setNomerKoshChemPlatili(product_than);
        transactionInbox.setSummaZaChtoPlatili(amount_for_what);
        transactionInbox.setSummaChemPlatili(amount_than);
        transactionInbox.setNomerTranzaktzii(666);
        transactionInbox.setOperatziya(operatziya);
        transactionInbox.setElektrNomerTerminala(elektrNomerTerminala);
        transactionInbox.setGrafNomerSlugKarty(service_card);
        transactionInbox.setOtkudaTranz(4);
        transactionInbox.setSertif(" ");
        transactionInbox.setGuid(null);
        transactionInbox.setIdPost(0);
        transactionInbox.setForcedClientId(null);
        transactionInbox.setForcedClientType(null);
        transactionInbox.setForcedOldSchema(false);
        transactionInbox.setInOnline(false);
        this.transactionInboxRepository.save(transactionInbox);

        // сохранить в корзину
        final TransactionStorage transactionStorage = new TransactionStorage();
        transactionStorage.setDataZapisi(transactionInbox.getDataZapisi());
        transactionStorage.setVremyaZapisi(transactionInbox.getVremyaZapisi());
        transactionStorage.setData(transactionInbox.getData());
        transactionStorage.setVremya(transactionInbox.getVremya());
        transactionStorage.setEmitentVladeltzaKarty(transactionInbox.getEmitentVladelKarti());
        transactionStorage.setGraficheskiNomer(transactionInbox.getGrNomer());
        transactionStorage.setEmitentPoKotoromu(transactionInbox.getEmGdeObsl());
        transactionStorage.setTipTr(transactionInbox.getTypeTr());
        transactionStorage.setNomerKoshZaChtoPlatili(transactionInbox.getNomerKoshZaChtoPlatili());
        transactionStorage.setNomerKoshChemPlatili(transactionInbox.getNomerKoshChemPlatili());
        transactionStorage.setSummaZaChtoPlatili(transactionInbox.getSummaZaChtoPlatili());
        transactionStorage.setSummaChemPlatili(transactionInbox.getSummaChemPlatili());
        transactionStorage.setNomerTranzaktzii(transactionInbox.getNomerTranzaktzii());
        transactionStorage.setOperatziya(transactionInbox.getOperatziya());
        transactionStorage.setGrafNomerSlugKarty(transactionInbox.getGrafNomerSlugKarty());
        transactionStorage.setElektrNomerTerminala(transactionInbox.getElektrNomerTerminala());
        transactionStorage.setIdKtoObslugil(this.personnelRepository.findFirstByIdUrovnyaDostupa(1).getIdCheloveka());
        transactionStorage.setOtkudaTranz(transactionInbox.getOtkudaTranz());
        transactionStorage.setSertif(transactionInbox.getSertif());
        transactionStorage.setIdPost(transactionInbox.getIdPost());
        transactionStorage.setGuidWithPos(transactionInbox.getGuidWithPos());
        transactionStorage.setInOnline(transactionInbox.isInOnline());
        this.transactionStorageRepository.save(transactionStorage);

        return ((transactionInbox.getGuidWithPos() != null) && (transactionStorage.getTrnGuid() != null));
    }


    /**
     * Парсит время в формате "Hh:Mm:Ss" в секунды.
     *
     * @param time
     * @return
     */
    private int parseTime(String time) {
        final String[] timeHhMm = time.split(":");
        final int timeHh = Integer.parseInt(timeHhMm[0]);
        final int timeMm = Integer.parseInt(timeHhMm[1]);
        final int timeSs = Integer.parseInt(timeHhMm[2]);
        return (timeHh * 60 * 60) + (timeMm * 60) + timeSs;
    }

}
