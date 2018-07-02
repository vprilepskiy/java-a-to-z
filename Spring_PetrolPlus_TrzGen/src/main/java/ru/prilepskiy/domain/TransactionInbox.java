package ru.prilepskiy.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Транзакции принятые, но не обработанные.
 *
 * Created by VLADIMIR on 22.05.2018.
 */
@Entity(name="Ecfil045")
//@Table(schema = "MAGICASH5_177")
public class TransactionInbox {
    private Date dataZapisi;
    private int vremyaZapisi;
    private Date data;
    private int vremya;
    private long emitentVladelKarti;
    private long grNomer;
    private long typeTr;
    private long emGdeObsl;
    private long nomerKoshZaChtoPlatili;
    private long nomerKoshChemPlatili;
    private BigDecimal summaZaChtoPlatili;
    private BigDecimal summaChemPlatili;
    private long nomerTranzaktzii;
    private long operatziya;
    private long elektrNomerTerminala;
    private long grafNomerSlugKarty;
    private long otkudaTranz;
    private String sertif;
    private String guid;
    private long idPost;
    private Long forcedClientId;
    private Long forcedClientType;
    private boolean forcedOldSchema;
    @Id
    @GeneratedValue(generator = "db-uuid0")
    @GenericGenerator(name = "db-uuid0", strategy = "guid")
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
    @Column(name = "EMITENT_VLADEL_KARTI", nullable = false, precision = 0)
    public long getEmitentVladelKarti() {
        return emitentVladelKarti;
    }

    public void setEmitentVladelKarti(long emitentVladelKarti) {
        this.emitentVladelKarti = emitentVladelKarti;
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
    @Column(name = "TYPE_TR", nullable = false, precision = 0)
    public long getTypeTr() {
        return typeTr;
    }

    public void setTypeTr(long typeTr) {
        this.typeTr = typeTr;
    }

    @Basic
    @Column(name = "EM_GDE_OBSL", nullable = false, precision = 0)
    public long getEmGdeObsl() {
        return emGdeObsl;
    }

    public void setEmGdeObsl(long emGdeObsl) {
        this.emGdeObsl = emGdeObsl;
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
    @Column(name = "ELEKTR_NOMER_TERMINALA", nullable = false, precision = 0)
    public long getElektrNomerTerminala() {
        return elektrNomerTerminala;
    }

    public void setElektrNomerTerminala(long elektrNomerTerminala) {
        this.elektrNomerTerminala = elektrNomerTerminala;
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
    @Column(name = "GUID", nullable = true, length = 32)
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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
    @Column(name = "FORCED_CLIENT_ID", nullable = true, precision = 0)
    public Long getForcedClientId() {
        return forcedClientId;
    }

    public void setForcedClientId(Long forcedClientId) {
        this.forcedClientId = forcedClientId;
    }

    @Basic
    @Column(name = "FORCED_CLIENT_TYPE", nullable = true, precision = 0)
    public Long getForcedClientType() {
        return forcedClientType;
    }

    public void setForcedClientType(Long forcedClientType) {
        this.forcedClientType = forcedClientType;
    }

    @Basic
    @Column(name = "FORCED_OLD_SCHEMA", nullable = false, precision = 0)
    public boolean isForcedOldSchema() {
        return forcedOldSchema;
    }

    public void setForcedOldSchema(boolean forcedOldSchema) {
        this.forcedOldSchema = forcedOldSchema;
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

        TransactionInbox transactionInbox = (TransactionInbox) o;

        if (vremyaZapisi != transactionInbox.vremyaZapisi) return false;
        if (vremya != transactionInbox.vremya) return false;
        if (emitentVladelKarti != transactionInbox.emitentVladelKarti) return false;
        if (grNomer != transactionInbox.grNomer) return false;
        if (typeTr != transactionInbox.typeTr) return false;
        if (emGdeObsl != transactionInbox.emGdeObsl) return false;
        if (nomerKoshZaChtoPlatili != transactionInbox.nomerKoshZaChtoPlatili) return false;
        if (nomerKoshChemPlatili != transactionInbox.nomerKoshChemPlatili) return false;
        if (summaZaChtoPlatili != transactionInbox.summaZaChtoPlatili) return false;
        if (summaChemPlatili != transactionInbox.summaChemPlatili) return false;
        if (nomerTranzaktzii != transactionInbox.nomerTranzaktzii) return false;
        if (operatziya != transactionInbox.operatziya) return false;
        if (elektrNomerTerminala != transactionInbox.elektrNomerTerminala) return false;
        if (grafNomerSlugKarty != transactionInbox.grafNomerSlugKarty) return false;
        if (otkudaTranz != transactionInbox.otkudaTranz) return false;
        if (idPost != transactionInbox.idPost) return false;
        if (forcedOldSchema != transactionInbox.forcedOldSchema) return false;
        if (isInOnline != transactionInbox.isInOnline) return false;
        if (dataZapisi != null ? !dataZapisi.equals(transactionInbox.dataZapisi) : transactionInbox.dataZapisi != null) return false;
        if (data != null ? !data.equals(transactionInbox.data) : transactionInbox.data != null) return false;
        if (sertif != null ? !sertif.equals(transactionInbox.sertif) : transactionInbox.sertif != null) return false;
        if (guid != null ? !guid.equals(transactionInbox.guid) : transactionInbox.guid != null) return false;
        if (forcedClientId != null ? !forcedClientId.equals(transactionInbox.forcedClientId) : transactionInbox.forcedClientId != null)
            return false;
        if (forcedClientType != null ? !forcedClientType.equals(transactionInbox.forcedClientType) : transactionInbox.forcedClientType != null)
            return false;
        if (guidWithPos != null ? !guidWithPos.equals(transactionInbox.guidWithPos) : transactionInbox.guidWithPos != null)
            return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = dataZapisi != null ? dataZapisi.hashCode() : 0;
        result = 31 * result + vremyaZapisi;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + vremya;
        result = 31 * result + (int) (emitentVladelKarti ^ (emitentVladelKarti >>> 32));
        result = 31 * result + (int) (grNomer ^ (grNomer >>> 32));
        result = 31 * result + (int) (typeTr ^ (typeTr >>> 32));
        result = 31 * result + (int) (emGdeObsl ^ (emGdeObsl >>> 32));
        result = 31 * result + (int) (nomerKoshZaChtoPlatili ^ (nomerKoshZaChtoPlatili >>> 32));
        result = 31 * result + (int) (nomerKoshChemPlatili ^ (nomerKoshChemPlatili >>> 32));
        result = 31 * result + (summaZaChtoPlatili != null ? summaZaChtoPlatili.hashCode() : 0);
        result = 31 * result + (summaChemPlatili != null ? summaChemPlatili.hashCode() : 0);
        result = 31 * result + (int) (nomerTranzaktzii ^ (nomerTranzaktzii >>> 32));
        result = 31 * result + (int) (operatziya ^ (operatziya >>> 32));
        result = 31 * result + (int) (elektrNomerTerminala ^ (elektrNomerTerminala >>> 32));
        result = 31 * result + (int) (grafNomerSlugKarty ^ (grafNomerSlugKarty >>> 32));
        result = 31 * result + (int) (otkudaTranz ^ (otkudaTranz >>> 32));
        result = 31 * result + (sertif != null ? sertif.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        result = 31 * result + (int) (idPost ^ (idPost >>> 32));
        result = 31 * result + (forcedClientId != null ? forcedClientId.hashCode() : 0);
        result = 31 * result + (forcedClientType != null ? forcedClientType.hashCode() : 0);
        result = 31 * result + (forcedOldSchema ? 1 : 0);
        result = 31 * result + (guidWithPos != null ? guidWithPos.hashCode() : 0);
        result = 31 * result + (isInOnline ? 1 : 0);
        return result;
    }
}
