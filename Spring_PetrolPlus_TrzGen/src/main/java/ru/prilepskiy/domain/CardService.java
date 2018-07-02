package ru.prilepskiy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Кошельки карт.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Entity(name="Ecfil015")
@IdClass(CardServicePK.class)
public class CardService {
    @Id
    private long idKarty;
    private long priznakMlDiv10000;
    @Id
    private long idKoshelka;
    private long razmerKoshelka;
    private long granitzaOvardrafta;
    private long limit;
    private long idSchemy;
    private boolean individualniiSl;
    private long idPhysically;
    private Time lastLimitChangeDate;
    private Time limitTypeChangeDate;

    @Column(name = "ID_KARTY", nullable = false, precision = 0)
    public long getIdKarty() {
        return idKarty;
    }

    public void setIdKarty(long idKarty) {
        this.idKarty = idKarty;
    }

    @Basic
    @Column(name = "PRIZNAK_ML_DIV10000", nullable = false, precision = 0)
    public long getPriznakMlDiv10000() {
        return priznakMlDiv10000;
    }

    public void setPriznakMlDiv10000(long priznakMlDiv10000) {
        this.priznakMlDiv10000 = priznakMlDiv10000;
    }

    @Column(name = "ID_KOSHELKA", nullable = false, precision = 0)
    public long getIdKoshelka() {
        return idKoshelka;
    }

    public void setIdKoshelka(long idKoshelka) {
        this.idKoshelka = idKoshelka;
    }

    @Basic
    @Column(name = "RAZMER_KOSHELKA", nullable = false, precision = 2)
    public long getRazmerKoshelka() {
        return razmerKoshelka;
    }

    public void setRazmerKoshelka(long razmerKoshelka) {
        this.razmerKoshelka = razmerKoshelka;
    }

    @Basic
    @Column(name = "GRANITZA_OVARDRAFTA", nullable = false, precision = 2)
    public long getGranitzaOvardrafta() {
        return granitzaOvardrafta;
    }

    public void setGranitzaOvardrafta(long granitzaOvardrafta) {
        this.granitzaOvardrafta = granitzaOvardrafta;
    }

    @Basic
    @Column(name = "LIMIT", nullable = false, precision = 2)
    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    @Basic
    @Column(name = "ID_SCHEMY", nullable = false, precision = 0)
    public long getIdSchemy() {
        return idSchemy;
    }

    public void setIdSchemy(long idSchemy) {
        this.idSchemy = idSchemy;
    }

    @Basic
    @Column(name = "INDIVIDUALNII_SL", nullable = false, precision = 0)
    public boolean isIndividualniiSl() {
        return individualniiSl;
    }

    public void setIndividualniiSl(boolean individualniiSl) {
        this.individualniiSl = individualniiSl;
    }

    @Basic
    @Column(name = "ID_PHYSICALLY", nullable = false, precision = 0)
    public long getIdPhysically() {
        return idPhysically;
    }

    public void setIdPhysically(long idPhysically) {
        this.idPhysically = idPhysically;
    }

    @Basic
    @Column(name = "LAST_LIMIT_CHANGE_DATE", nullable = true)
    public Time getLastLimitChangeDate() {
        return lastLimitChangeDate;
    }

    public void setLastLimitChangeDate(Time lastLimitChangeDate) {
        this.lastLimitChangeDate = lastLimitChangeDate;
    }

    @Basic
    @Column(name = "LIMIT_TYPE_CHANGE_DATE", nullable = true)
    public Time getLimitTypeChangeDate() {
        return limitTypeChangeDate;
    }

    public void setLimitTypeChangeDate(Time limitTypeChangeDate) {
        this.limitTypeChangeDate = limitTypeChangeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardService cardService = (CardService) o;

        if (idKarty != cardService.idKarty) return false;
        if (priznakMlDiv10000 != cardService.priznakMlDiv10000) return false;
        if (idKoshelka != cardService.idKoshelka) return false;
        if (razmerKoshelka != cardService.razmerKoshelka) return false;
        if (granitzaOvardrafta != cardService.granitzaOvardrafta) return false;
        if (limit != cardService.limit) return false;
        if (idSchemy != cardService.idSchemy) return false;
        if (individualniiSl != cardService.individualniiSl) return false;
        if (idPhysically != cardService.idPhysically) return false;
        if (lastLimitChangeDate != null ? !lastLimitChangeDate.equals(cardService.lastLimitChangeDate) : cardService.lastLimitChangeDate != null)
            return false;
        if (limitTypeChangeDate != null ? !limitTypeChangeDate.equals(cardService.limitTypeChangeDate) : cardService.limitTypeChangeDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idKarty ^ (idKarty >>> 32));
        result = 31 * result + (int) (priznakMlDiv10000 ^ (priznakMlDiv10000 >>> 32));
        result = 31 * result + (int) (idKoshelka ^ (idKoshelka >>> 32));
        result = 31 * result + (int) (razmerKoshelka ^ (razmerKoshelka >>> 32));
        result = 31 * result + (int) (granitzaOvardrafta ^ (granitzaOvardrafta >>> 32));
        result = 31 * result + (int) (limit ^ (limit >>> 32));
        result = 31 * result + (int) (idSchemy ^ (idSchemy >>> 32));
        result = 31 * result + (individualniiSl ? 1 : 0);
        result = 31 * result + (int) (idPhysically ^ (idPhysically >>> 32));
        result = 31 * result + (lastLimitChangeDate != null ? lastLimitChangeDate.hashCode() : 0);
        result = 31 * result + (limitTypeChangeDate != null ? limitTypeChangeDate.hashCode() : 0);
        return result;
    }
}
