package ru.prilepskiy.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

/**
 * Корзина транзакций.
 *
 * Created by VLADIMIR on 22.05.2018.
 */
@Entity(name="Ecfil046")
//@Table(schema = "MAGICASH5_177")
public class TransactionStorage {
    private Date dataZapisi;
    private int vremyaZapisi;
    private Date data;
    private int vremya;
    private long emitentVladeltzaKarty;
    private long graficheskiNomer;
    private long emitentPoKotoromu;
    private long tipTr;
    private long nomerKoshZaChtoPlatili;
    private long nomerKoshChemPlatili;
    private BigDecimal summaZaChtoPlatili;
    private BigDecimal summaChemPlatili;
    private long nomerTranzaktzii;
    private long operatziya;
    private long grafNomerSlugKarty;
    private long elektrNomerTerminala;
    private long idKtoObslugil;
    private long otkudaTranz;
    private String sertif;
    @Id
    @GeneratedValue(generator = "db-uuid")
    @GenericGenerator(name = "db-uuid", strategy = "guid")
    private String trnGuid;
    private long idPost;
    private String guidWithPos;
    private boolean isInOnline;

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
    @Column(name = "EMITENT_VLADELTZA_KARTY", nullable = false, precision = 0)
    public long getEmitentVladeltzaKarty() {
        return emitentVladeltzaKarty;
    }

    public void setEmitentVladeltzaKarty(long emitentVladeltzaKarty) {
        this.emitentVladeltzaKarty = emitentVladeltzaKarty;
    }

    @Basic
    @Column(name = "GRAFICHESKI_NOMER", nullable = false, precision = 0)
    public long getGraficheskiNomer() {
        return graficheskiNomer;
    }

    public void setGraficheskiNomer(long graficheskiNomer) {
        this.graficheskiNomer = graficheskiNomer;
    }

    @Basic
    @Column(name = "EMITENT_PO_KOTOROMU", nullable = false, precision = 0)
    public long getEmitentPoKotoromu() {
        return emitentPoKotoromu;
    }

    public void setEmitentPoKotoromu(long emitentPoKotoromu) {
        this.emitentPoKotoromu = emitentPoKotoromu;
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
    @Column(name = "NOMER_KOSH_ZA_CHTO_PLATILI", nullable = false, precision = 0)
    public long getNomerKoshZaChtoPlatili() {
        return nomerKoshZaChtoPlatili;
    }

    public void setNomerKoshZaChtoPlatili(long nomerKoshZaChtoPlatili) {
        this.nomerKoshZaChtoPlatili = nomerKoshZaChtoPlatili;
    }

    @Basic
    @Column(name = "NOMER_KOSH_CHEM_PLATILI", nullable = false, precision = 0)
    public long getNomerKoshChemPlatili() {
        return nomerKoshChemPlatili;
    }

    public void setNomerKoshChemPlatili(long nomerKoshChemPlatili) {
        this.nomerKoshChemPlatili = nomerKoshChemPlatili;
    }

    @Basic
    @Column(name = "SUMMA_ZA_CHTO_PLATILI", nullable = false, precision = 2)
    public BigDecimal getSummaZaChtoPlatili() {
        return summaZaChtoPlatili;
    }

    public void setSummaZaChtoPlatili(BigDecimal summaZaChtoPlatili) {
        this.summaZaChtoPlatili = summaZaChtoPlatili;
    }

    @Basic
    @Column(name = "SUMMA_CHEM_PLATILI", nullable = false, precision = 2)
    public BigDecimal getSummaChemPlatili() {
        return summaChemPlatili;
    }

    public void setSummaChemPlatili(BigDecimal summaChemPlatili) {
        this.summaChemPlatili = summaChemPlatili;
    }

    @Basic
    @Column(name = "NOMER_TRANZAKTZII", nullable = false, precision = 0)
    public long getNomerTranzaktzii() {
        return nomerTranzaktzii;
    }

    public void setNomerTranzaktzii(long nomerTranzaktzii) {
        this.nomerTranzaktzii = nomerTranzaktzii;
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
    @Column(name = "GRAF_NOMER_SLUG_KARTY", nullable = false, precision = 0)
    public long getGrafNomerSlugKarty() {
        return grafNomerSlugKarty;
    }

    public void setGrafNomerSlugKarty(long grafNomerSlugKarty) {
        this.grafNomerSlugKarty = grafNomerSlugKarty;
    }

    @Basic
    @Column(name = "ELEKTR_NOMER_TERMINALA", nullable = false, precision = 0)
    public long getElektrNomerTerminala() {
        return elektrNomerTerminala;
    }

    public void setElektrNomerTerminala(long elektrNomerTerminala) {
        this.elektrNomerTerminala = elektrNomerTerminala;
    }

    @Basic
    @Column(name = "ID_KTO_OBSLUGIL", nullable = false, precision = 0)
    public long getIdKtoObslugil() {
        return idKtoObslugil;
    }

    public void setIdKtoObslugil(long idKtoObslugil) {
        this.idKtoObslugil = idKtoObslugil;
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
    @Column(name = "SERTIF", nullable = false, length = 40)
    public String getSertif() {
        return sertif;
    }

    public void setSertif(String sertif) {
        this.sertif = sertif;
    }

    @Basic
    @Column(name = "TRN_GUID", nullable = false, length = 32)
    public String getTrnGuid() {
        return trnGuid;
    }

    public void setTrnGuid(String trnGuid) {
        this.trnGuid = trnGuid;
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
    @Column(name = "GUID_WITH_POS", nullable = true, length = 32)
    public String getGuidWithPos() {
        return guidWithPos;
    }

    public void setGuidWithPos(String guidWithPos) {
        this.guidWithPos = guidWithPos;
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

        TransactionStorage transactionStorage = (TransactionStorage) o;

        if (vremyaZapisi != transactionStorage.vremyaZapisi) return false;
        if (vremya != transactionStorage.vremya) return false;
        if (emitentVladeltzaKarty != transactionStorage.emitentVladeltzaKarty) return false;
        if (graficheskiNomer != transactionStorage.graficheskiNomer) return false;
        if (emitentPoKotoromu != transactionStorage.emitentPoKotoromu) return false;
        if (tipTr != transactionStorage.tipTr) return false;
        if (nomerKoshZaChtoPlatili != transactionStorage.nomerKoshZaChtoPlatili) return false;
        if (nomerKoshChemPlatili != transactionStorage.nomerKoshChemPlatili) return false;
        if (summaZaChtoPlatili != transactionStorage.summaZaChtoPlatili) return false;
        if (summaChemPlatili != transactionStorage.summaChemPlatili) return false;
        if (nomerTranzaktzii != transactionStorage.nomerTranzaktzii) return false;
        if (operatziya != transactionStorage.operatziya) return false;
        if (grafNomerSlugKarty != transactionStorage.grafNomerSlugKarty) return false;
        if (elektrNomerTerminala != transactionStorage.elektrNomerTerminala) return false;
        if (idKtoObslugil != transactionStorage.idKtoObslugil) return false;
        if (otkudaTranz != transactionStorage.otkudaTranz) return false;
        if (idPost != transactionStorage.idPost) return false;
        if (isInOnline != transactionStorage.isInOnline) return false;
        if (dataZapisi != null ? !dataZapisi.equals(transactionStorage.dataZapisi) : transactionStorage.dataZapisi != null) return false;
        if (data != null ? !data.equals(transactionStorage.data) : transactionStorage.data != null) return false;
        if (sertif != null ? !sertif.equals(transactionStorage.sertif) : transactionStorage.sertif != null) return false;
        if (trnGuid != null ? !trnGuid.equals(transactionStorage.trnGuid) : transactionStorage.trnGuid != null) return false;
        if (guidWithPos != null ? !guidWithPos.equals(transactionStorage.guidWithPos) : transactionStorage.guidWithPos != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataZapisi != null ? dataZapisi.hashCode() : 0;
        result = 31 * result + vremyaZapisi;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + vremya;
        result = 31 * result + (int) (emitentVladeltzaKarty ^ (emitentVladeltzaKarty >>> 32));
        result = 31 * result + (int) (graficheskiNomer ^ (graficheskiNomer >>> 32));
        result = 31 * result + (int) (emitentPoKotoromu ^ (emitentPoKotoromu >>> 32));
        result = 31 * result + (int) (tipTr ^ (tipTr >>> 32));
        result = 31 * result + (int) (nomerKoshZaChtoPlatili ^ (nomerKoshZaChtoPlatili >>> 32));
        result = 31 * result + (int) (nomerKoshChemPlatili ^ (nomerKoshChemPlatili >>> 32));
        result = 31 * result + (summaZaChtoPlatili != null ? summaZaChtoPlatili.hashCode() : 0);
        result = 31 * result + (summaChemPlatili != null ? summaChemPlatili.hashCode() : 0);
        result = 31 * result + (int) (nomerTranzaktzii ^ (nomerTranzaktzii >>> 32));
        result = 31 * result + (int) (operatziya ^ (operatziya >>> 32));
        result = 31 * result + (int) (grafNomerSlugKarty ^ (grafNomerSlugKarty >>> 32));
        result = 31 * result + (int) (elektrNomerTerminala ^ (elektrNomerTerminala >>> 32));
        result = 31 * result + (int) (idKtoObslugil ^ (idKtoObslugil >>> 32));
        result = 31 * result + (int) (otkudaTranz ^ (otkudaTranz >>> 32));
        result = 31 * result + (sertif != null ? sertif.hashCode() : 0);
        result = 31 * result + (trnGuid != null ? trnGuid.hashCode() : 0);
        result = 31 * result + (int) (idPost ^ (idPost >>> 32));
        result = 31 * result + (guidWithPos != null ? guidWithPos.hashCode() : 0);
        result = 31 * result + (isInOnline ? 1 : 0);
        return result;
    }
}
