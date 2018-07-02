package ru.prilepskiy.domain;

import javax.persistence.*;
import java.sql.Time;

/**
 * Карты. (служебные, клиентские)
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Entity(name="Ecfil012")
public class Card {
    @Id
    private long idKarty;
    private long idPrinadlejnosti;
    private long idVladeltza;
//    @ManyToOne
//    @JoinColumn(name = "ID_VLADELTZA", referencedColumnName = "ID_FIRMY", updatable = false)
//    private Client client;
    private long idSostoyanya;
    private long grNomer;
    private String elektronyNomer;
    private long tipKarty;
    private long idFyzicheski;
    private Time dataVydachi;
    private Time dataIzyatiya;
    private long idKtoVydal;
    private long idKtoIzyal;
    private boolean pometka;
    private long nomTermDlyaOperatKart;
    private String prichinaNerabochSost;
    private String derjatel;
    private String flagZaschityPin;
    private boolean newCard;
    private long isoNumber;
    private boolean crc;
    private long idFirmKart;
    private long idFilialKart;
    private Time expDate;
    private String panKodKlientskoiKarty;
    private String pinCod;
    private long idLoyaltyPattern;
    private boolean cardEmv;
    private String eMail;
    private Long personId;
    private boolean allCardInBl;
    private long idActions;
    private Time dateFirstStateBl;
    private Time cardExpDate;

    @Basic
    @Column(name = "ID_KARTY", nullable = false, precision = 0)
    public long getIdKarty() {
        return idKarty;
    }

    public void setIdKarty(long idKarty) {
        this.idKarty = idKarty;
    }

    @Basic
    @Column(name = "ID_PRINADLEJNOSTI", nullable = false, precision = 0)
    public long getIdPrinadlejnosti() {
        return idPrinadlejnosti;
    }

    public void setIdPrinadlejnosti(long idPrinadlejnosti) {
        this.idPrinadlejnosti = idPrinadlejnosti;
    }



    @Basic
    @Column(name = "ID_VLADELTZA", nullable = false, precision = 0)
    public long getIdVladeltza() {
        return idVladeltza;
    }

    public void setIdVladeltza(long idVladeltza) {
        this.idVladeltza = idVladeltza;
    }

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }

    @Basic
    @Column(name = "ID_SOSTOYANYA", nullable = false, precision = 0)
    public long getIdSostoyanya() {
        return idSostoyanya;
    }

    public void setIdSostoyanya(long idSostoyanya) {
        this.idSostoyanya = idSostoyanya;
    }

    @Basic
    @Column(name = "GR_NOMER", nullable = false, precision = 0)
    public long getGrNomer() {
        return grNomer;
    }

    public void setGrNomer(long grNomer) {
        this.grNomer = grNomer;
    }

    @Basic
    @Column(name = "ELEKTRONY_NOMER", nullable = false, length = 24)
    public String getElektronyNomer() {
        return elektronyNomer;
    }

    public void setElektronyNomer(String elektronyNomer) {
        this.elektronyNomer = elektronyNomer;
    }

    @Basic
    @Column(name = "TIP_KARTY", nullable = false, precision = 0)
    public long getTipKarty() {
        return tipKarty;
    }

    public void setTipKarty(long tipKarty) {
        this.tipKarty = tipKarty;
    }

    @Basic
    @Column(name = "ID_FYZICHESKI", nullable = false, precision = 0)
    public long getIdFyzicheski() {
        return idFyzicheski;
    }

    public void setIdFyzicheski(long idFyzicheski) {
        this.idFyzicheski = idFyzicheski;
    }

    @Basic
    @Column(name = "DATA_VYDACHI", nullable = false)
    public Time getDataVydachi() {
        return dataVydachi;
    }

    public void setDataVydachi(Time dataVydachi) {
        this.dataVydachi = dataVydachi;
    }

    @Basic
    @Column(name = "DATA_IZYATIYA", nullable = false)
    public Time getDataIzyatiya() {
        return dataIzyatiya;
    }

    public void setDataIzyatiya(Time dataIzyatiya) {
        this.dataIzyatiya = dataIzyatiya;
    }

    @Basic
    @Column(name = "ID_KTO_VYDAL", nullable = false, precision = 0)
    public long getIdKtoVydal() {
        return idKtoVydal;
    }

    public void setIdKtoVydal(long idKtoVydal) {
        this.idKtoVydal = idKtoVydal;
    }

    @Basic
    @Column(name = "ID_KTO_IZYAL", nullable = false, precision = 0)
    public long getIdKtoIzyal() {
        return idKtoIzyal;
    }

    public void setIdKtoIzyal(long idKtoIzyal) {
        this.idKtoIzyal = idKtoIzyal;
    }

    @Basic
    @Column(name = "POMETKA", nullable = false, precision = 0)
    public boolean isPometka() {
        return pometka;
    }

    public void setPometka(boolean pometka) {
        this.pometka = pometka;
    }

    @Basic
    @Column(name = "NOM_TERM_DLYA_OPERAT_KART", nullable = false, precision = 0)
    public long getNomTermDlyaOperatKart() {
        return nomTermDlyaOperatKart;
    }

    public void setNomTermDlyaOperatKart(long nomTermDlyaOperatKart) {
        this.nomTermDlyaOperatKart = nomTermDlyaOperatKart;
    }

    @Basic
    @Column(name = "PRICHINA_NERABOCH_SOST", nullable = false, length = 40)
    public String getPrichinaNerabochSost() {
        return prichinaNerabochSost;
    }

    public void setPrichinaNerabochSost(String prichinaNerabochSost) {
        this.prichinaNerabochSost = prichinaNerabochSost;
    }

    @Basic
    @Column(name = "DERJATEL", nullable = false, length = 40)
    public String getDerjatel() {
        return derjatel;
    }

    public void setDerjatel(String derjatel) {
        this.derjatel = derjatel;
    }

    @Basic
    @Column(name = "FLAG_ZASCHITY_PIN", nullable = false, length = 10)
    public String getFlagZaschityPin() {
        return flagZaschityPin;
    }

    public void setFlagZaschityPin(String flagZaschityPin) {
        this.flagZaschityPin = flagZaschityPin;
    }

    @Basic
    @Column(name = "NEW_CARD", nullable = false, precision = 0)
    public boolean isNewCard() {
        return newCard;
    }

    public void setNewCard(boolean newCard) {
        this.newCard = newCard;
    }

    @Basic
    @Column(name = "ISO_NUMBER", nullable = false, precision = 0)
    public long getIsoNumber() {
        return isoNumber;
    }

    public void setIsoNumber(long isoNumber) {
        this.isoNumber = isoNumber;
    }

    @Basic
    @Column(name = "CRC", nullable = false, precision = 0)
    public boolean isCrc() {
        return crc;
    }

    public void setCrc(boolean crc) {
        this.crc = crc;
    }

    @Basic
    @Column(name = "ID_FIRM_KART", nullable = false, precision = 0)
    public long getIdFirmKart() {
        return idFirmKart;
    }

    public void setIdFirmKart(long idFirmKart) {
        this.idFirmKart = idFirmKart;
    }

    @Basic
    @Column(name = "ID_FILIAL_KART", nullable = false, precision = 0)
    public long getIdFilialKart() {
        return idFilialKart;
    }

    public void setIdFilialKart(long idFilialKart) {
        this.idFilialKart = idFilialKart;
    }

    @Basic
    @Column(name = "EXP_DATE", nullable = false)
    public Time getExpDate() {
        return expDate;
    }

    public void setExpDate(Time expDate) {
        this.expDate = expDate;
    }

    @Basic
    @Column(name = "PAN_KOD_KLIENTSKOI_KARTY", nullable = false, length = 30)
    public String getPanKodKlientskoiKarty() {
        return panKodKlientskoiKarty;
    }

    public void setPanKodKlientskoiKarty(String panKodKlientskoiKarty) {
        this.panKodKlientskoiKarty = panKodKlientskoiKarty;
    }

    @Basic
    @Column(name = "PIN_COD", nullable = false, length = 8)
    public String getPinCod() {
        return pinCod;
    }

    public void setPinCod(String pinCod) {
        this.pinCod = pinCod;
    }

    @Basic
    @Column(name = "ID_LOYALTY_PATTERN", nullable = false, precision = 0)
    public long getIdLoyaltyPattern() {
        return idLoyaltyPattern;
    }

    public void setIdLoyaltyPattern(long idLoyaltyPattern) {
        this.idLoyaltyPattern = idLoyaltyPattern;
    }

    @Basic
    @Column(name = "CARD_EMV", nullable = false, precision = 0)
    public boolean isCardEmv() {
        return cardEmv;
    }

    public void setCardEmv(boolean cardEmv) {
        this.cardEmv = cardEmv;
    }

    @Basic
    @Column(name = "E_MAIL", nullable = true, length = 100)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "PERSON_ID", nullable = true, precision = 0)
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "ALL_CARD_IN_BL", nullable = false, precision = 0)
    public boolean isAllCardInBl() {
        return allCardInBl;
    }

    public void setAllCardInBl(boolean allCardInBl) {
        this.allCardInBl = allCardInBl;
    }

    @Basic
    @Column(name = "ID_ACTIONS", nullable = false, precision = 0)
    public long getIdActions() {
        return idActions;
    }

    public void setIdActions(long idActions) {
        this.idActions = idActions;
    }

    @Basic
    @Column(name = "DATE_FIRST_STATE_BL", nullable = false)
    public Time getDateFirstStateBl() {
        return dateFirstStateBl;
    }

    public void setDateFirstStateBl(Time dateFirstStateBl) {
        this.dateFirstStateBl = dateFirstStateBl;
    }

    @Basic
    @Column(name = "CARD_EXP_DATE", nullable = false)
    public Time getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(Time cardExpDate) {
        this.cardExpDate = cardExpDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (idKarty != card.idKarty) return false;
        if (idPrinadlejnosti != card.idPrinadlejnosti) return false;
        if (idVladeltza != card.idVladeltza) return false;
        if (idSostoyanya != card.idSostoyanya) return false;
        if (grNomer != card.grNomer) return false;
        if (tipKarty != card.tipKarty) return false;
        if (idFyzicheski != card.idFyzicheski) return false;
        if (idKtoVydal != card.idKtoVydal) return false;
        if (idKtoIzyal != card.idKtoIzyal) return false;
        if (pometka != card.pometka) return false;
        if (nomTermDlyaOperatKart != card.nomTermDlyaOperatKart) return false;
        if (newCard != card.newCard) return false;
        if (isoNumber != card.isoNumber) return false;
        if (crc != card.crc) return false;
        if (idFirmKart != card.idFirmKart) return false;
        if (idFilialKart != card.idFilialKart) return false;
        if (idLoyaltyPattern != card.idLoyaltyPattern) return false;
        if (cardEmv != card.cardEmv) return false;
        if (allCardInBl != card.allCardInBl) return false;
        if (idActions != card.idActions) return false;
        if (elektronyNomer != null ? !elektronyNomer.equals(card.elektronyNomer) : card.elektronyNomer != null)
            return false;
        if (dataVydachi != null ? !dataVydachi.equals(card.dataVydachi) : card.dataVydachi != null)
            return false;
        if (dataIzyatiya != null ? !dataIzyatiya.equals(card.dataIzyatiya) : card.dataIzyatiya != null)
            return false;
        if (prichinaNerabochSost != null ? !prichinaNerabochSost.equals(card.prichinaNerabochSost) : card.prichinaNerabochSost != null)
            return false;
        if (derjatel != null ? !derjatel.equals(card.derjatel) : card.derjatel != null) return false;
        if (flagZaschityPin != null ? !flagZaschityPin.equals(card.flagZaschityPin) : card.flagZaschityPin != null)
            return false;
        if (expDate != null ? !expDate.equals(card.expDate) : card.expDate != null) return false;
        if (panKodKlientskoiKarty != null ? !panKodKlientskoiKarty.equals(card.panKodKlientskoiKarty) : card.panKodKlientskoiKarty != null)
            return false;
        if (pinCod != null ? !pinCod.equals(card.pinCod) : card.pinCod != null) return false;
        if (eMail != null ? !eMail.equals(card.eMail) : card.eMail != null) return false;
        if (personId != null ? !personId.equals(card.personId) : card.personId != null) return false;
        if (dateFirstStateBl != null ? !dateFirstStateBl.equals(card.dateFirstStateBl) : card.dateFirstStateBl != null)
            return false;
        if (cardExpDate != null ? !cardExpDate.equals(card.cardExpDate) : card.cardExpDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idKarty ^ (idKarty >>> 32));
        result = 31 * result + (int) (idPrinadlejnosti ^ (idPrinadlejnosti >>> 32));
        result = 31 * result + (int) (idVladeltza ^ (idVladeltza >>> 32));
        result = 31 * result + (int) (idSostoyanya ^ (idSostoyanya >>> 32));
        result = 31 * result + (int) (grNomer ^ (grNomer >>> 32));
        result = 31 * result + (elektronyNomer != null ? elektronyNomer.hashCode() : 0);
        result = 31 * result + (int) (tipKarty ^ (tipKarty >>> 32));
        result = 31 * result + (int) (idFyzicheski ^ (idFyzicheski >>> 32));
        result = 31 * result + (dataVydachi != null ? dataVydachi.hashCode() : 0);
        result = 31 * result + (dataIzyatiya != null ? dataIzyatiya.hashCode() : 0);
        result = 31 * result + (int) (idKtoVydal ^ (idKtoVydal >>> 32));
        result = 31 * result + (int) (idKtoIzyal ^ (idKtoIzyal >>> 32));
        result = 31 * result + (pometka ? 1 : 0);
        result = 31 * result + (int) (nomTermDlyaOperatKart ^ (nomTermDlyaOperatKart >>> 32));
        result = 31 * result + (prichinaNerabochSost != null ? prichinaNerabochSost.hashCode() : 0);
        result = 31 * result + (derjatel != null ? derjatel.hashCode() : 0);
        result = 31 * result + (flagZaschityPin != null ? flagZaschityPin.hashCode() : 0);
        result = 31 * result + (newCard ? 1 : 0);
        result = 31 * result + (int) (isoNumber ^ (isoNumber >>> 32));
        result = 31 * result + (crc ? 1 : 0);
        result = 31 * result + (int) (idFirmKart ^ (idFirmKart >>> 32));
        result = 31 * result + (int) (idFilialKart ^ (idFilialKart >>> 32));
        result = 31 * result + (expDate != null ? expDate.hashCode() : 0);
        result = 31 * result + (panKodKlientskoiKarty != null ? panKodKlientskoiKarty.hashCode() : 0);
        result = 31 * result + (pinCod != null ? pinCod.hashCode() : 0);
        result = 31 * result + (int) (idLoyaltyPattern ^ (idLoyaltyPattern >>> 32));
        result = 31 * result + (cardEmv ? 1 : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (allCardInBl ? 1 : 0);
        result = 31 * result + (int) (idActions ^ (idActions >>> 32));
        result = 31 * result + (dateFirstStateBl != null ? dateFirstStateBl.hashCode() : 0);
        result = 31 * result + (cardExpDate != null ? cardExpDate.hashCode() : 0);
        return result;
    }
}
