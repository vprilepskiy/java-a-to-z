package ru.prilepskiy.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by VLADIMIR on 28.05.2018.
 */
public class CardServicePK implements Serializable {
    @Id
    private long idKarty;
    @Id
    private long idKoshelka;

    @Column(name = "ID_KARTY", nullable = false, precision = 0)
    public long getIdKarty() {
        return idKarty;
    }

    public void setIdKarty(long idKarty) {
        this.idKarty = idKarty;
    }

    @Column(name = "ID_KOSHELKA", nullable = false, precision = 0)
    public long getIdKoshelka() {
        return idKoshelka;
    }

    public void setIdKoshelka(long idKoshelka) {
        this.idKoshelka = idKoshelka;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardServicePK cardServicePK = (CardServicePK) o;

        if (idKarty != cardServicePK.idKarty) return false;
        if (idKoshelka != cardServicePK.idKoshelka) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idKarty ^ (idKarty >>> 32));
        result = 31 * result + (int) (idKoshelka ^ (idKoshelka >>> 32));
        return result;
    }
}
