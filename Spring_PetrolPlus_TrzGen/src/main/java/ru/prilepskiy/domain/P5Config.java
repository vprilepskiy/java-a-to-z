package ru.prilepskiy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Номер эмитента.
 *
 * Created by VLADIMIR on 22.05.2018.
 */
@Entity
public class P5Config implements Serializable {

    @Id
    private long idEmitent;
    private String nameEmitent;
    private long idFilial;
    private String version;
    private Time dateVersion;
    private String nameCurrency;
    private long numberPc;

    @Basic
    @Column(name = "ID_EMITENT", nullable = false, precision = 0)
    public long getIdEmitent() {
        return idEmitent;
    }

    public void setIdEmitent(long idEmitent) {
        this.idEmitent = idEmitent;
    }

    @Basic
    @Column(name = "NAME_EMITENT", nullable = false, length = 40)
    public String getNameEmitent() {
        return nameEmitent;
    }

    public void setNameEmitent(String nameEmitent) {
        this.nameEmitent = nameEmitent;
    }

    @Basic
    @Column(name = "ID_FILIAL", nullable = false, precision = 0)
    public long getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(long idFilial) {
        this.idFilial = idFilial;
    }

    @Basic
    @Column(name = "VERSION", nullable = false, length = 10)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "DATE_VERSION", nullable = false)
    public Time getDateVersion() {
        return dateVersion;
    }

    public void setDateVersion(Time dateVersion) {
        this.dateVersion = dateVersion;
    }

    @Basic
    @Column(name = "NAME_CURRENCY", nullable = false, length = 40)
    public String getNameCurrency() {
        return nameCurrency;
    }

    public void setNameCurrency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
    }

    @Basic
    @Column(name = "NUMBER_PC", nullable = false, precision = 0)
    public long getNumberPc() {
        return numberPc;
    }

    public void setNumberPc(long numberPc) {
        this.numberPc = numberPc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        P5Config p5Config = (P5Config) o;

        if (idEmitent != p5Config.idEmitent) return false;
        if (idFilial != p5Config.idFilial) return false;
        if (numberPc != p5Config.numberPc) return false;
        if (nameEmitent != null ? !nameEmitent.equals(p5Config.nameEmitent) : p5Config.nameEmitent != null)
            return false;
        if (version != null ? !version.equals(p5Config.version) : p5Config.version != null) return false;
        if (dateVersion != null ? !dateVersion.equals(p5Config.dateVersion) : p5Config.dateVersion != null)
            return false;
        if (nameCurrency != null ? !nameCurrency.equals(p5Config.nameCurrency) : p5Config.nameCurrency != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEmitent ^ (idEmitent >>> 32));
        result = 31 * result + (nameEmitent != null ? nameEmitent.hashCode() : 0);
        result = 31 * result + (int) (idFilial ^ (idFilial >>> 32));
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (dateVersion != null ? dateVersion.hashCode() : 0);
        result = 31 * result + (nameCurrency != null ? nameCurrency.hashCode() : 0);
        result = 31 * result + (int) (numberPc ^ (numberPc >>> 32));
        return result;
    }
}
