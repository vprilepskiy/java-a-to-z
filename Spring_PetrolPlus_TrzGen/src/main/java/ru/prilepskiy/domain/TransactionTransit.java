package ru.prilepskiy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by VLADIMIR on 30.05.2018.
 */
@Entity(name = "Ecfil144")
public class TransactionTransit {
    private Date data;
    private int vremya;
    private Date dataZapisi;
    private int vremyaZapisi;
    private long emitentVladelKarti;
    private long emitentGdeObslugilis;
    private long nomerTerminala;
    private long grafNomerKartiKlienta;
    private long idChemMoego;
    private long idZaChtoMoego;
    private long idChemGlobalnogo;
    private long idZaChtoGlobalnogo;
    private long idChemChushogo;
    private long idZaChtoChushogo;
    private long summaChem;
    private long summaZaChto;
    private long tchenaTerminala;
    private long tchenaPerescheta;
    private boolean egoSchetNash;
    private long operachiya;
    private boolean dlyaOtdachi;
    private boolean bilaOtdacha;
    private long prichinaIzmeneniya;
    private long grafNomerSlugebnoiKarti;
    private boolean podtvergdenie;
    private long tipTranzakchii;
    private long summaChemRealnaya;
    private long otkudaTranz;
    private long baseDeltaPrice;
    private long baseDeltaSum;
    private String trnGuid;
    private long posDeltaPrice;
    private long posDeltaSum;
    private long moment;
    private long idTo;
    private long idWhoServ;
    private long idCardState;
    private String linkGuid;
    private Long priceInPosCurrency;
    private Long sumInPosCurrency;
    private Long posDeltaPriceInCurrency;
    private Long posDeltaSumInCurrency;
    private String shiftGuid;
    private long mainServiceIdCard;
    private long mainServiceIdPos;
    private long mainServiceIdGlob;
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
    @Column(name = "EMITENT_VLADEL_KARTI", nullable = false, precision = 0)
    public long getEmitentVladelKarti() {
        return emitentVladelKarti;
    }

    public void setEmitentVladelKarti(long emitentVladelKarti) {
        this.emitentVladelKarti = emitentVladelKarti;
    }

    @Basic
    @Column(name = "EMITENT_GDE_OBSLUGILIS", nullable = false, precision = 0)
    public long getEmitentGdeObslugilis() {
        return emitentGdeObslugilis;
    }

    public void setEmitentGdeObslugilis(long emitentGdeObslugilis) {
        this.emitentGdeObslugilis = emitentGdeObslugilis;
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
    @Column(name = "GRAF_NOMER_KARTI_KLIENTA", nullable = false, precision = 0)
    public long getGrafNomerKartiKlienta() {
        return grafNomerKartiKlienta;
    }

    public void setGrafNomerKartiKlienta(long grafNomerKartiKlienta) {
        this.grafNomerKartiKlienta = grafNomerKartiKlienta;
    }

    @Basic
    @Column(name = "ID_CHEM_MOEGO", nullable = false, precision = 0)
    public long getIdChemMoego() {
        return idChemMoego;
    }

    public void setIdChemMoego(long idChemMoego) {
        this.idChemMoego = idChemMoego;
    }

    @Basic
    @Column(name = "ID_ZA_CHTO_MOEGO", nullable = false, precision = 0)
    public long getIdZaChtoMoego() {
        return idZaChtoMoego;
    }

    public void setIdZaChtoMoego(long idZaChtoMoego) {
        this.idZaChtoMoego = idZaChtoMoego;
    }

    @Basic
    @Column(name = "ID_CHEM_GLOBALNOGO", nullable = false, precision = 0)
    public long getIdChemGlobalnogo() {
        return idChemGlobalnogo;
    }

    public void setIdChemGlobalnogo(long idChemGlobalnogo) {
        this.idChemGlobalnogo = idChemGlobalnogo;
    }

    @Basic
    @Column(name = "ID_ZA_CHTO_GLOBALNOGO", nullable = false, precision = 0)
    public long getIdZaChtoGlobalnogo() {
        return idZaChtoGlobalnogo;
    }

    public void setIdZaChtoGlobalnogo(long idZaChtoGlobalnogo) {
        this.idZaChtoGlobalnogo = idZaChtoGlobalnogo;
    }

    @Basic
    @Column(name = "ID_CHEM_CHUSHOGO", nullable = false, precision = 0)
    public long getIdChemChushogo() {
        return idChemChushogo;
    }

    public void setIdChemChushogo(long idChemChushogo) {
        this.idChemChushogo = idChemChushogo;
    }

    @Basic
    @Column(name = "ID_ZA_CHTO_CHUSHOGO", nullable = false, precision = 0)
    public long getIdZaChtoChushogo() {
        return idZaChtoChushogo;
    }

    public void setIdZaChtoChushogo(long idZaChtoChushogo) {
        this.idZaChtoChushogo = idZaChtoChushogo;
    }

    @Basic
    @Column(name = "SUMMA_CHEM", nullable = false, precision = 2)
    public long getSummaChem() {
        return summaChem;
    }

    public void setSummaChem(long summaChem) {
        this.summaChem = summaChem;
    }

    @Basic
    @Column(name = "SUMMA_ZA_CHTO", nullable = false, precision = 2)
    public long getSummaZaChto() {
        return summaZaChto;
    }

    public void setSummaZaChto(long summaZaChto) {
        this.summaZaChto = summaZaChto;
    }

    @Basic
    @Column(name = "TCHENA_TERMINALA", nullable = false, precision = 2)
    public long getTchenaTerminala() {
        return tchenaTerminala;
    }

    public void setTchenaTerminala(long tchenaTerminala) {
        this.tchenaTerminala = tchenaTerminala;
    }

    @Basic
    @Column(name = "TCHENA_PERESCHETA", nullable = false, precision = 2)
    public long getTchenaPerescheta() {
        return tchenaPerescheta;
    }

    public void setTchenaPerescheta(long tchenaPerescheta) {
        this.tchenaPerescheta = tchenaPerescheta;
    }

    @Basic
    @Column(name = "EGO_SCHET_NASH", nullable = false, precision = 0)
    public boolean isEgoSchetNash() {
        return egoSchetNash;
    }

    public void setEgoSchetNash(boolean egoSchetNash) {
        this.egoSchetNash = egoSchetNash;
    }

    @Basic
    @Column(name = "OPERACHIYA", nullable = false, precision = 0)
    public long getOperachiya() {
        return operachiya;
    }

    public void setOperachiya(long operachiya) {
        this.operachiya = operachiya;
    }

    @Basic
    @Column(name = "DLYA_OTDACHI", nullable = false, precision = 0)
    public boolean isDlyaOtdachi() {
        return dlyaOtdachi;
    }

    public void setDlyaOtdachi(boolean dlyaOtdachi) {
        this.dlyaOtdachi = dlyaOtdachi;
    }

    @Basic
    @Column(name = "BILA_OTDACHA", nullable = false, precision = 0)
    public boolean isBilaOtdacha() {
        return bilaOtdacha;
    }

    public void setBilaOtdacha(boolean bilaOtdacha) {
        this.bilaOtdacha = bilaOtdacha;
    }

    @Basic
    @Column(name = "PRICHINA_IZMENENIYA", nullable = false, precision = 0)
    public long getPrichinaIzmeneniya() {
        return prichinaIzmeneniya;
    }

    public void setPrichinaIzmeneniya(long prichinaIzmeneniya) {
        this.prichinaIzmeneniya = prichinaIzmeneniya;
    }

    @Basic
    @Column(name = "GRAF_NOMER_SLUGEBNOI_KARTI", nullable = false, precision = 0)
    public long getGrafNomerSlugebnoiKarti() {
        return grafNomerSlugebnoiKarti;
    }

    public void setGrafNomerSlugebnoiKarti(long grafNomerSlugebnoiKarti) {
        this.grafNomerSlugebnoiKarti = grafNomerSlugebnoiKarti;
    }

    @Basic
    @Column(name = "PODTVERGDENIE", nullable = false, precision = 0)
    public boolean isPodtvergdenie() {
        return podtvergdenie;
    }

    public void setPodtvergdenie(boolean podtvergdenie) {
        this.podtvergdenie = podtvergdenie;
    }

    @Basic
    @Column(name = "TIP_TRANZAKCHII", nullable = false, precision = 0)
    public long getTipTranzakchii() {
        return tipTranzakchii;
    }

    public void setTipTranzakchii(long tipTranzakchii) {
        this.tipTranzakchii = tipTranzakchii;
    }

    @Basic
    @Column(name = "SUMMA_CHEM_REALNAYA", nullable = false, precision = 2)
    public long getSummaChemRealnaya() {
        return summaChemRealnaya;
    }

    public void setSummaChemRealnaya(long summaChemRealnaya) {
        this.summaChemRealnaya = summaChemRealnaya;
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
    @Column(name = "MAIN_SERVICE_ID_CARD", nullable = false, precision = 0)
    public long getMainServiceIdCard() {
        return mainServiceIdCard;
    }

    public void setMainServiceIdCard(long mainServiceIdCard) {
        this.mainServiceIdCard = mainServiceIdCard;
    }

    @Basic
    @Column(name = "MAIN_SERVICE_ID_POS", nullable = false, precision = 0)
    public long getMainServiceIdPos() {
        return mainServiceIdPos;
    }

    public void setMainServiceIdPos(long mainServiceIdPos) {
        this.mainServiceIdPos = mainServiceIdPos;
    }

    @Basic
    @Column(name = "MAIN_SERVICE_ID_GLOB", nullable = false, precision = 0)
    public long getMainServiceIdGlob() {
        return mainServiceIdGlob;
    }

    public void setMainServiceIdGlob(long mainServiceIdGlob) {
        this.mainServiceIdGlob = mainServiceIdGlob;
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

        TransactionTransit transactionTransit = (TransactionTransit) o;

        if (vremya != transactionTransit.vremya) return false;
        if (vremyaZapisi != transactionTransit.vremyaZapisi) return false;
        if (emitentVladelKarti != transactionTransit.emitentVladelKarti) return false;
        if (emitentGdeObslugilis != transactionTransit.emitentGdeObslugilis) return false;
        if (nomerTerminala != transactionTransit.nomerTerminala) return false;
        if (grafNomerKartiKlienta != transactionTransit.grafNomerKartiKlienta) return false;
        if (idChemMoego != transactionTransit.idChemMoego) return false;
        if (idZaChtoMoego != transactionTransit.idZaChtoMoego) return false;
        if (idChemGlobalnogo != transactionTransit.idChemGlobalnogo) return false;
        if (idZaChtoGlobalnogo != transactionTransit.idZaChtoGlobalnogo) return false;
        if (idChemChushogo != transactionTransit.idChemChushogo) return false;
        if (idZaChtoChushogo != transactionTransit.idZaChtoChushogo) return false;
        if (summaChem != transactionTransit.summaChem) return false;
        if (summaZaChto != transactionTransit.summaZaChto) return false;
        if (tchenaTerminala != transactionTransit.tchenaTerminala) return false;
        if (tchenaPerescheta != transactionTransit.tchenaPerescheta) return false;
        if (egoSchetNash != transactionTransit.egoSchetNash) return false;
        if (operachiya != transactionTransit.operachiya) return false;
        if (dlyaOtdachi != transactionTransit.dlyaOtdachi) return false;
        if (bilaOtdacha != transactionTransit.bilaOtdacha) return false;
        if (prichinaIzmeneniya != transactionTransit.prichinaIzmeneniya) return false;
        if (grafNomerSlugebnoiKarti != transactionTransit.grafNomerSlugebnoiKarti) return false;
        if (podtvergdenie != transactionTransit.podtvergdenie) return false;
        if (tipTranzakchii != transactionTransit.tipTranzakchii) return false;
        if (summaChemRealnaya != transactionTransit.summaChemRealnaya) return false;
        if (otkudaTranz != transactionTransit.otkudaTranz) return false;
        if (baseDeltaPrice != transactionTransit.baseDeltaPrice) return false;
        if (baseDeltaSum != transactionTransit.baseDeltaSum) return false;
        if (posDeltaPrice != transactionTransit.posDeltaPrice) return false;
        if (posDeltaSum != transactionTransit.posDeltaSum) return false;
        if (moment != transactionTransit.moment) return false;
        if (idTo != transactionTransit.idTo) return false;
        if (idWhoServ != transactionTransit.idWhoServ) return false;
        if (idCardState != transactionTransit.idCardState) return false;
        if (mainServiceIdCard != transactionTransit.mainServiceIdCard) return false;
        if (mainServiceIdPos != transactionTransit.mainServiceIdPos) return false;
        if (mainServiceIdGlob != transactionTransit.mainServiceIdGlob) return false;
        if (isInOnline != transactionTransit.isInOnline) return false;
        if (data != null ? !data.equals(transactionTransit.data) : transactionTransit.data != null) return false;
        if (dataZapisi != null ? !dataZapisi.equals(transactionTransit.dataZapisi) : transactionTransit.dataZapisi != null) return false;
        if (trnGuid != null ? !trnGuid.equals(transactionTransit.trnGuid) : transactionTransit.trnGuid != null) return false;
        if (linkGuid != null ? !linkGuid.equals(transactionTransit.linkGuid) : transactionTransit.linkGuid != null) return false;
        if (priceInPosCurrency != null ? !priceInPosCurrency.equals(transactionTransit.priceInPosCurrency) : transactionTransit.priceInPosCurrency != null)
            return false;
        if (sumInPosCurrency != null ? !sumInPosCurrency.equals(transactionTransit.sumInPosCurrency) : transactionTransit.sumInPosCurrency != null)
            return false;
        if (posDeltaPriceInCurrency != null ? !posDeltaPriceInCurrency.equals(transactionTransit.posDeltaPriceInCurrency) : transactionTransit.posDeltaPriceInCurrency != null)
            return false;
        if (posDeltaSumInCurrency != null ? !posDeltaSumInCurrency.equals(transactionTransit.posDeltaSumInCurrency) : transactionTransit.posDeltaSumInCurrency != null)
            return false;
        if (shiftGuid != null ? !shiftGuid.equals(transactionTransit.shiftGuid) : transactionTransit.shiftGuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + vremya;
        result = 31 * result + (dataZapisi != null ? dataZapisi.hashCode() : 0);
        result = 31 * result + vremyaZapisi;
        result = 31 * result + (int) (emitentVladelKarti ^ (emitentVladelKarti >>> 32));
        result = 31 * result + (int) (emitentGdeObslugilis ^ (emitentGdeObslugilis >>> 32));
        result = 31 * result + (int) (nomerTerminala ^ (nomerTerminala >>> 32));
        result = 31 * result + (int) (grafNomerKartiKlienta ^ (grafNomerKartiKlienta >>> 32));
        result = 31 * result + (int) (idChemMoego ^ (idChemMoego >>> 32));
        result = 31 * result + (int) (idZaChtoMoego ^ (idZaChtoMoego >>> 32));
        result = 31 * result + (int) (idChemGlobalnogo ^ (idChemGlobalnogo >>> 32));
        result = 31 * result + (int) (idZaChtoGlobalnogo ^ (idZaChtoGlobalnogo >>> 32));
        result = 31 * result + (int) (idChemChushogo ^ (idChemChushogo >>> 32));
        result = 31 * result + (int) (idZaChtoChushogo ^ (idZaChtoChushogo >>> 32));
        result = 31 * result + (int) (summaChem ^ (summaChem >>> 32));
        result = 31 * result + (int) (summaZaChto ^ (summaZaChto >>> 32));
        result = 31 * result + (int) (tchenaTerminala ^ (tchenaTerminala >>> 32));
        result = 31 * result + (int) (tchenaPerescheta ^ (tchenaPerescheta >>> 32));
        result = 31 * result + (egoSchetNash ? 1 : 0);
        result = 31 * result + (int) (operachiya ^ (operachiya >>> 32));
        result = 31 * result + (dlyaOtdachi ? 1 : 0);
        result = 31 * result + (bilaOtdacha ? 1 : 0);
        result = 31 * result + (int) (prichinaIzmeneniya ^ (prichinaIzmeneniya >>> 32));
        result = 31 * result + (int) (grafNomerSlugebnoiKarti ^ (grafNomerSlugebnoiKarti >>> 32));
        result = 31 * result + (podtvergdenie ? 1 : 0);
        result = 31 * result + (int) (tipTranzakchii ^ (tipTranzakchii >>> 32));
        result = 31 * result + (int) (summaChemRealnaya ^ (summaChemRealnaya >>> 32));
        result = 31 * result + (int) (otkudaTranz ^ (otkudaTranz >>> 32));
        result = 31 * result + (int) (baseDeltaPrice ^ (baseDeltaPrice >>> 32));
        result = 31 * result + (int) (baseDeltaSum ^ (baseDeltaSum >>> 32));
        result = 31 * result + (trnGuid != null ? trnGuid.hashCode() : 0);
        result = 31 * result + (int) (posDeltaPrice ^ (posDeltaPrice >>> 32));
        result = 31 * result + (int) (posDeltaSum ^ (posDeltaSum >>> 32));
        result = 31 * result + (int) (moment ^ (moment >>> 32));
        result = 31 * result + (int) (idTo ^ (idTo >>> 32));
        result = 31 * result + (int) (idWhoServ ^ (idWhoServ >>> 32));
        result = 31 * result + (int) (idCardState ^ (idCardState >>> 32));
        result = 31 * result + (linkGuid != null ? linkGuid.hashCode() : 0);
        result = 31 * result + (priceInPosCurrency != null ? priceInPosCurrency.hashCode() : 0);
        result = 31 * result + (sumInPosCurrency != null ? sumInPosCurrency.hashCode() : 0);
        result = 31 * result + (posDeltaPriceInCurrency != null ? posDeltaPriceInCurrency.hashCode() : 0);
        result = 31 * result + (posDeltaSumInCurrency != null ? posDeltaSumInCurrency.hashCode() : 0);
        result = 31 * result + (shiftGuid != null ? shiftGuid.hashCode() : 0);
        result = 31 * result + (int) (mainServiceIdCard ^ (mainServiceIdCard >>> 32));
        result = 31 * result + (int) (mainServiceIdPos ^ (mainServiceIdPos >>> 32));
        result = 31 * result + (int) (mainServiceIdGlob ^ (mainServiceIdGlob >>> 32));
        result = 31 * result + (isInOnline ? 1 : 0);
        return result;
    }
}
