package ru.prilepskiy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by VLADIMIR on 30.05.2018.
 */
@Entity(name = "Ecfil139")
public class TransactionLocal {
    private Date data;
    private int vremya;
    private Date dataZapisi;
    private int vremyaZapisi;
    private long idKlienta;
    private long tzenaTerminala;
    private long nomerSchemy;
    private long idKoshZaChto;
    private long idKoshSchem;
    private BigDecimal summaZaChto;
    private BigDecimal summaZaproshenayaChem;
    private long emGdeObsl;
    private long operatziya;
    private long idPrichiny;
    private long nomerTerminala;
    private long tzenaPerescheta;
    private long idPrinadl;
    private BigDecimal summaChemRealno;
    private long tipTr;
    private long grNomerKartyOper;
    private boolean bulaLoyalnost;
    private long otkudaTranz;
    private long baseDeltaPrice;
    private long baseDeltaSum;
    private String trnGuid;
    private long posDeltaPrice;
    private long posDeltaSum;
    private long grNomer;
    private long moment;
    private long idTo;
    private long idWhoServ;
    private long peredana;
    private long podtvergdenie;
    private long idCardState;
    private String linkGuid;
    private String comments;
    private long idPost;
    private long filialWhere;
    private Long priceInPosCurrency;
    private Long sumInPosCurrency;
    private Long posDeltaPriceInCurrency;
    private Long posDeltaSumInCurrency;
    private String shiftGuid;
    private long mainServiceId;
    private String contractGuid;
    private boolean isInOnline;

    @Basic
    @Column(name = "DATA", nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Basic
    @Column(name = "VREMYA", nullable = false, precision = 0)
    public int getVremya() {
        return vremya;
    }

    public void setVremya(int vremya) {
        this.vremya = vremya;
    }

    @Basic
    @Column(name = "DATA_ZAPISI", nullable = false)
    public Date getDataZapisi() {
        return dataZapisi;
    }

    public void setDataZapisi(Date dataZapisi) {
        this.dataZapisi = dataZapisi;
    }

    @Basic
    @Column(name = "VREMYA_ZAPISI", nullable = false, precision = 0)
    public int getVremyaZapisi() {
        return vremyaZapisi;
    }

    public void setVremyaZapisi(int vremyaZapisi) {
        this.vremyaZapisi = vremyaZapisi;
    }

    @Basic
    @Column(name = "ID_KLIENTA", nullable = false, precision = 0)
    public long getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(long idKlienta) {
        this.idKlienta = idKlienta;
    }

    @Basic
    @Column(name = "TZENA_TERMINALA", nullable = false, precision = 2)
    public long getTzenaTerminala() {
        return tzenaTerminala;
    }

    public void setTzenaTerminala(long tzenaTerminala) {
        this.tzenaTerminala = tzenaTerminala;
    }

    @Basic
    @Column(name = "NOMER_SCHEMY", nullable = false, precision = 0)
    public long getNomerSchemy() {
        return nomerSchemy;
    }

    public void setNomerSchemy(long nomerSchemy) {
        this.nomerSchemy = nomerSchemy;
    }

    @Basic
    @Column(name = "ID_KOSH_ZA_CHTO", nullable = false, precision = 0)
    public long getIdKoshZaChto() {
        return idKoshZaChto;
    }

    public void setIdKoshZaChto(long idKoshZaChto) {
        this.idKoshZaChto = idKoshZaChto;
    }

    @Basic
    @Column(name = "ID_KOSH_SCHEM", nullable = false, precision = 0)
    public long getIdKoshSchem() {
        return idKoshSchem;
    }

    public void setIdKoshSchem(long idKoshSchem) {
        this.idKoshSchem = idKoshSchem;
    }

    @Basic
    @Column(name = "SUMMA_ZA_CHTO", nullable = false, precision = 2)
    public BigDecimal getSummaZaChto() {
        return summaZaChto;
    }

    public void setSummaZaChto(BigDecimal summaZaChto) {
        this.summaZaChto = summaZaChto;
    }

    @Basic
    @Column(name = "SUMMA_ZAPROSHENAYA_CHEM", nullable = false, precision = 2)
    public BigDecimal getSummaZaproshenayaChem() {
        return summaZaproshenayaChem;
    }

    public void setSummaZaproshenayaChem(BigDecimal summaZaproshenayaChem) {
        this.summaZaproshenayaChem = summaZaproshenayaChem;
    }

    @Basic
    @Column(name = "EM_GDE_OBSL", nullable = false, precision = 2)
    public long getEmGdeObsl() {
        return emGdeObsl;
    }

    public void setEmGdeObsl(long emGdeObsl) {
        this.emGdeObsl = emGdeObsl;
    }

    @Basic
    @Column(name = "OPERATZIYA", nullable = false, precision = 0)
    public long getOperatziya() {
        return operatziya;
    }

    public void setOperatziya(long operatziya) {
        this.operatziya = operatziya;
    }

    @Basic
    @Column(name = "ID_PRICHINY", nullable = false, precision = 0)
    public long getIdPrichiny() {
        return idPrichiny;
    }

    public void setIdPrichiny(long idPrichiny) {
        this.idPrichiny = idPrichiny;
    }

    @Basic
    @Column(name = "NOMER_TERMINALA", nullable = false, precision = 0)
    public long getNomerTerminala() {
        return nomerTerminala;
    }

    public void setNomerTerminala(long nomerTerminala) {
        this.nomerTerminala = nomerTerminala;
    }

    @Basic
    @Column(name = "TZENA_PERESCHETA", nullable = false, precision = 2)
    public long getTzenaPerescheta() {
        return tzenaPerescheta;
    }

    public void setTzenaPerescheta(long tzenaPerescheta) {
        this.tzenaPerescheta = tzenaPerescheta;
    }

    @Basic
    @Column(name = "ID_PRINADL", nullable = false, precision = 0)
    public long getIdPrinadl() {
        return idPrinadl;
    }

    public void setIdPrinadl(long idPrinadl) {
        this.idPrinadl = idPrinadl;
    }

    @Basic
    @Column(name = "SUMMA_CHEM_REALNO", nullable = false, precision = 2)
    public BigDecimal getSummaChemRealno() {
        return summaChemRealno;
    }

    public void setSummaChemRealno(BigDecimal summaChemRealno) {
        this.summaChemRealno = summaChemRealno;
    }

    @Basic
    @Column(name = "TIP_TR", nullable = false, precision = 0)
    public long getTipTr() {
        return tipTr;
    }

    public void setTipTr(long tipTr) {
        this.tipTr = tipTr;
    }

    @Basic
    @Column(name = "GR_NOMER_KARTY_OPER", nullable = false, precision = 0)
    public long getGrNomerKartyOper() {
        return grNomerKartyOper;
    }

    public void setGrNomerKartyOper(long grNomerKartyOper) {
        this.grNomerKartyOper = grNomerKartyOper;
    }

    @Basic
    @Column(name = "BULA_LOYALNOST", nullable = false, precision = 0)
    public boolean isBulaLoyalnost() {
        return bulaLoyalnost;
    }

    public void setBulaLoyalnost(boolean bulaLoyalnost) {
        this.bulaLoyalnost = bulaLoyalnost;
    }

    @Basic
    @Column(name = "OTKUDA_TRANZ", nullable = false, precision = 0)
    public long getOtkudaTranz() {
        return otkudaTranz;
    }

    public void setOtkudaTranz(long otkudaTranz) {
        this.otkudaTranz = otkudaTranz;
    }

    @Basic
    @Column(name = "BASE_DELTA_PRICE", nullable = false, precision = 0)
    public long getBaseDeltaPrice() {
        return baseDeltaPrice;
    }

    public void setBaseDeltaPrice(long baseDeltaPrice) {
        this.baseDeltaPrice = baseDeltaPrice;
    }

    @Basic
    @Column(name = "BASE_DELTA_SUM", nullable = false, precision = 0)
    public long getBaseDeltaSum() {
        return baseDeltaSum;
    }

    public void setBaseDeltaSum(long baseDeltaSum) {
        this.baseDeltaSum = baseDeltaSum;
    }

    @Id
    @Column(name = "TRN_GUID", nullable = false, length = 32)
    public String getTrnGuid() {
        return trnGuid;
    }

    public void setTrnGuid(String trnGuid) {
        this.trnGuid = trnGuid;
    }

    @Basic
    @Column(name = "POS_DELTA_PRICE", nullable = false, precision = 0)
    public long getPosDeltaPrice() {
        return posDeltaPrice;
    }

    public void setPosDeltaPrice(long posDeltaPrice) {
        this.posDeltaPrice = posDeltaPrice;
    }

    @Basic
    @Column(name = "POS_DELTA_SUM", nullable = false, precision = 0)
    public long getPosDeltaSum() {
        return posDeltaSum;
    }

    public void setPosDeltaSum(long posDeltaSum) {
        this.posDeltaSum = posDeltaSum;
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
    @Column(name = "MOMENT", nullable = false, precision = 0)
    public long getMoment() {
        return moment;
    }

    public void setMoment(long moment) {
        this.moment = moment;
    }

    @Basic
    @Column(name = "ID_TO", nullable = false, precision = 0)
    public long getIdTo() {
        return idTo;
    }

    public void setIdTo(long idTo) {
        this.idTo = idTo;
    }

    @Basic
    @Column(name = "ID_WHO_SERV", nullable = false, precision = 0)
    public long getIdWhoServ() {
        return idWhoServ;
    }

    public void setIdWhoServ(long idWhoServ) {
        this.idWhoServ = idWhoServ;
    }

    @Basic
    @Column(name = "PEREDANA", nullable = false, precision = 0)
    public long getPeredana() {
        return peredana;
    }

    public void setPeredana(long peredana) {
        this.peredana = peredana;
    }

    @Basic
    @Column(name = "PODTVERGDENIE", nullable = false, precision = 0)
    public long getPodtvergdenie() {
        return podtvergdenie;
    }

    public void setPodtvergdenie(long podtvergdenie) {
        this.podtvergdenie = podtvergdenie;
    }

    @Basic
    @Column(name = "ID_CARD_STATE", nullable = false, precision = 0)
    public long getIdCardState() {
        return idCardState;
    }

    public void setIdCardState(long idCardState) {
        this.idCardState = idCardState;
    }

    @Basic
    @Column(name = "LINK_GUID", nullable = false, length = 32)
    public String getLinkGuid() {
        return linkGuid;
    }

    public void setLinkGuid(String linkGuid) {
        this.linkGuid = linkGuid;
    }

    @Basic
    @Column(name = "COMMENTS", nullable = true, length = 500)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "ID_POST", nullable = false, precision = 0)
    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    @Basic
    @Column(name = "FILIAL_WHERE", nullable = false, precision = 0)
    public long getFilialWhere() {
        return filialWhere;
    }

    public void setFilialWhere(long filialWhere) {
        this.filialWhere = filialWhere;
    }

    @Basic
    @Column(name = "PRICE_IN_POS_CURRENCY", nullable = true, precision = 0)
    public Long getPriceInPosCurrency() {
        return priceInPosCurrency;
    }

    public void setPriceInPosCurrency(Long priceInPosCurrency) {
        this.priceInPosCurrency = priceInPosCurrency;
    }

    @Basic
    @Column(name = "SUM_IN_POS_CURRENCY", nullable = true, precision = 0)
    public Long getSumInPosCurrency() {
        return sumInPosCurrency;
    }

    public void setSumInPosCurrency(Long sumInPosCurrency) {
        this.sumInPosCurrency = sumInPosCurrency;
    }

    @Basic
    @Column(name = "POS_DELTA_PRICE_IN_CURRENCY", nullable = true, precision = 0)
    public Long getPosDeltaPriceInCurrency() {
        return posDeltaPriceInCurrency;
    }

    public void setPosDeltaPriceInCurrency(Long posDeltaPriceInCurrency) {
        this.posDeltaPriceInCurrency = posDeltaPriceInCurrency;
    }

    @Basic
    @Column(name = "POS_DELTA_SUM_IN_CURRENCY", nullable = true, precision = 0)
    public Long getPosDeltaSumInCurrency() {
        return posDeltaSumInCurrency;
    }

    public void setPosDeltaSumInCurrency(Long posDeltaSumInCurrency) {
        this.posDeltaSumInCurrency = posDeltaSumInCurrency;
    }

    @Basic
    @Column(name = "SHIFT_GUID", nullable = true, length = 32)
    public String getShiftGuid() {
        return shiftGuid;
    }

    public void setShiftGuid(String shiftGuid) {
        this.shiftGuid = shiftGuid;
    }

    @Basic
    @Column(name = "MAIN_SERVICE_ID", nullable = false, precision = 0)
    public long getMainServiceId() {
        return mainServiceId;
    }

    public void setMainServiceId(long mainServiceId) {
        this.mainServiceId = mainServiceId;
    }

    @Basic
    @Column(name = "CONTRACT_GUID", nullable = true, length = 32)
    public String getContractGuid() {
        return contractGuid;
    }

    public void setContractGuid(String contractGuid) {
        this.contractGuid = contractGuid;
    }

    @Basic
    @Column(name = "IS_IN_ONLINE", nullable = false, precision = 0)
    public boolean isInOnline() {
        return isInOnline;
    }

    public void setInOnline(boolean inOnline) {
        isInOnline = inOnline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionLocal transactionLocal = (TransactionLocal) o;

        if (vremya != transactionLocal.vremya) return false;
        if (vremyaZapisi != transactionLocal.vremyaZapisi) return false;
        if (idKlienta != transactionLocal.idKlienta) return false;
        if (tzenaTerminala != transactionLocal.tzenaTerminala) return false;
        if (nomerSchemy != transactionLocal.nomerSchemy) return false;
        if (idKoshZaChto != transactionLocal.idKoshZaChto) return false;
        if (idKoshSchem != transactionLocal.idKoshSchem) return false;
        if (summaZaChto != transactionLocal.summaZaChto) return false;
        if (summaZaproshenayaChem != transactionLocal.summaZaproshenayaChem) return false;
        if (emGdeObsl != transactionLocal.emGdeObsl) return false;
        if (operatziya != transactionLocal.operatziya) return false;
        if (idPrichiny != transactionLocal.idPrichiny) return false;
        if (nomerTerminala != transactionLocal.nomerTerminala) return false;
        if (tzenaPerescheta != transactionLocal.tzenaPerescheta) return false;
        if (idPrinadl != transactionLocal.idPrinadl) return false;
        if (summaChemRealno != transactionLocal.summaChemRealno) return false;
        if (tipTr != transactionLocal.tipTr) return false;
        if (grNomerKartyOper != transactionLocal.grNomerKartyOper) return false;
        if (bulaLoyalnost != transactionLocal.bulaLoyalnost) return false;
        if (otkudaTranz != transactionLocal.otkudaTranz) return false;
        if (baseDeltaPrice != transactionLocal.baseDeltaPrice) return false;
        if (baseDeltaSum != transactionLocal.baseDeltaSum) return false;
        if (posDeltaPrice != transactionLocal.posDeltaPrice) return false;
        if (posDeltaSum != transactionLocal.posDeltaSum) return false;
        if (grNomer != transactionLocal.grNomer) return false;
        if (moment != transactionLocal.moment) return false;
        if (idTo != transactionLocal.idTo) return false;
        if (idWhoServ != transactionLocal.idWhoServ) return false;
        if (peredana != transactionLocal.peredana) return false;
        if (podtvergdenie != transactionLocal.podtvergdenie) return false;
        if (idCardState != transactionLocal.idCardState) return false;
        if (idPost != transactionLocal.idPost) return false;
        if (filialWhere != transactionLocal.filialWhere) return false;
        if (mainServiceId != transactionLocal.mainServiceId) return false;
        if (isInOnline != transactionLocal.isInOnline) return false;
        if (data != null ? !data.equals(transactionLocal.data) : transactionLocal.data != null) return false;
        if (dataZapisi != null ? !dataZapisi.equals(transactionLocal.dataZapisi) : transactionLocal.dataZapisi != null) return false;
        if (trnGuid != null ? !trnGuid.equals(transactionLocal.trnGuid) : transactionLocal.trnGuid != null) return false;
        if (linkGuid != null ? !linkGuid.equals(transactionLocal.linkGuid) : transactionLocal.linkGuid != null) return false;
        if (comments != null ? !comments.equals(transactionLocal.comments) : transactionLocal.comments != null) return false;
        if (priceInPosCurrency != null ? !priceInPosCurrency.equals(transactionLocal.priceInPosCurrency) : transactionLocal.priceInPosCurrency != null)
            return false;
        if (sumInPosCurrency != null ? !sumInPosCurrency.equals(transactionLocal.sumInPosCurrency) : transactionLocal.sumInPosCurrency != null)
            return false;
        if (posDeltaPriceInCurrency != null ? !posDeltaPriceInCurrency.equals(transactionLocal.posDeltaPriceInCurrency) : transactionLocal.posDeltaPriceInCurrency != null)
            return false;
        if (posDeltaSumInCurrency != null ? !posDeltaSumInCurrency.equals(transactionLocal.posDeltaSumInCurrency) : transactionLocal.posDeltaSumInCurrency != null)
            return false;
        if (shiftGuid != null ? !shiftGuid.equals(transactionLocal.shiftGuid) : transactionLocal.shiftGuid != null) return false;
        if (contractGuid != null ? !contractGuid.equals(transactionLocal.contractGuid) : transactionLocal.contractGuid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + vremya;
        result = 31 * result + (dataZapisi != null ? dataZapisi.hashCode() : 0);
        result = 31 * result + vremyaZapisi;
        result = 31 * result + (int) (idKlienta ^ (idKlienta >>> 32));
        result = 31 * result + (int) (tzenaTerminala ^ (tzenaTerminala >>> 32));
        result = 31 * result + (int) (nomerSchemy ^ (nomerSchemy >>> 32));
        result = 31 * result + (int) (idKoshZaChto ^ (idKoshZaChto >>> 32));
        result = 31 * result + (int) (idKoshSchem ^ (idKoshSchem >>> 32));
        result = 31 * result + (summaZaChto != null ? summaZaChto.hashCode() : 0);
        result = 31 * result + (summaZaproshenayaChem != null ? summaZaproshenayaChem.hashCode() : 0);
        result = 31 * result + (int) (emGdeObsl ^ (emGdeObsl >>> 32));
        result = 31 * result + (int) (operatziya ^ (operatziya >>> 32));
        result = 31 * result + (int) (idPrichiny ^ (idPrichiny >>> 32));
        result = 31 * result + (int) (nomerTerminala ^ (nomerTerminala >>> 32));
        result = 31 * result + (int) (tzenaPerescheta ^ (tzenaPerescheta >>> 32));
        result = 31 * result + (int) (idPrinadl ^ (idPrinadl >>> 32));
        result = 31 * result + (summaChemRealno != null ? summaChemRealno.hashCode() : 0);
        result = 31 * result + (int) (tipTr ^ (tipTr >>> 32));
        result = 31 * result + (int) (grNomerKartyOper ^ (grNomerKartyOper >>> 32));
        result = 31 * result + (bulaLoyalnost ? 1 : 0);
        result = 31 * result + (int) (otkudaTranz ^ (otkudaTranz >>> 32));
        result = 31 * result + (int) (baseDeltaPrice ^ (baseDeltaPrice >>> 32));
        result = 31 * result + (int) (baseDeltaSum ^ (baseDeltaSum >>> 32));
        result = 31 * result + (trnGuid != null ? trnGuid.hashCode() : 0);
        result = 31 * result + (int) (posDeltaPrice ^ (posDeltaPrice >>> 32));
        result = 31 * result + (int) (posDeltaSum ^ (posDeltaSum >>> 32));
        result = 31 * result + (int) (grNomer ^ (grNomer >>> 32));
        result = 31 * result + (int) (moment ^ (moment >>> 32));
        result = 31 * result + (int) (idTo ^ (idTo >>> 32));
        result = 31 * result + (int) (idWhoServ ^ (idWhoServ >>> 32));
        result = 31 * result + (int) (peredana ^ (peredana >>> 32));
        result = 31 * result + (int) (podtvergdenie ^ (podtvergdenie >>> 32));
        result = 31 * result + (int) (idCardState ^ (idCardState >>> 32));
        result = 31 * result + (linkGuid != null ? linkGuid.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (int) (idPost ^ (idPost >>> 32));
        result = 31 * result + (int) (filialWhere ^ (filialWhere >>> 32));
        result = 31 * result + (priceInPosCurrency != null ? priceInPosCurrency.hashCode() : 0);
        result = 31 * result + (sumInPosCurrency != null ? sumInPosCurrency.hashCode() : 0);
        result = 31 * result + (posDeltaPriceInCurrency != null ? posDeltaPriceInCurrency.hashCode() : 0);
        result = 31 * result + (posDeltaSumInCurrency != null ? posDeltaSumInCurrency.hashCode() : 0);
        result = 31 * result + (shiftGuid != null ? shiftGuid.hashCode() : 0);
        result = 31 * result + (int) (mainServiceId ^ (mainServiceId >>> 32));
        result = 31 * result + (contractGuid != null ? contractGuid.hashCode() : 0);
        result = 31 * result + (isInOnline ? 1 : 0);
        return result;
    }
}
