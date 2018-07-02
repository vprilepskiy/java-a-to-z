package ru.prilepskiy.domain;

import javax.persistence.*;
import java.sql.Time;

/**
 * Список ТО.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Entity(name="Ecfil037")
@IdClass(AddressPK.class)
public class Address {
    private long idTochkiObslugivaniya;
    private long idEmitent;
    private long idFiliala;
    private Time dataUstanovki;
    private String nazvanie;
    private String adres;
    private boolean pometka;
    private String eMail;

    @Id
    @Column(name = "ID_TOCHKI_OBSLUGIVANIYA", nullable = false, precision = 0)
    public long getIdTochkiObslugivaniya() {
        return idTochkiObslugivaniya;
    }

    public void setIdTochkiObslugivaniya(long idTochkiObslugivaniya) {
        this.idTochkiObslugivaniya = idTochkiObslugivaniya;
    }

    @Id
    @Column(name = "ID_EMITENT", nullable = false, precision = 0)
    public long getIdEmitent() {
        return idEmitent;
    }

    public void setIdEmitent(long idEmitent) {
        this.idEmitent = idEmitent;
    }

    @Id
    @Column(name = "ID_FILIALA", nullable = false, precision = 0)
    public long getIdFiliala() {
        return idFiliala;
    }

    public void setIdFiliala(long idFiliala) {
        this.idFiliala = idFiliala;
    }

    @Basic
    @Column(name = "DATA_USTANOVKI", nullable = false)
    public Time getDataUstanovki() {
        return dataUstanovki;
    }

    public void setDataUstanovki(Time dataUstanovki) {
        this.dataUstanovki = dataUstanovki;
    }

    @Basic
    @Column(name = "NAZVANIE", nullable = false, length = 40)
    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    @Basic
    @Column(name = "ADRES", nullable = false, length = 100)
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
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
    @Column(name = "E_MAIL", nullable = true, length = 100)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (idTochkiObslugivaniya != address.idTochkiObslugivaniya) return false;
        if (idEmitent != address.idEmitent) return false;
        if (idFiliala != address.idFiliala) return false;
        if (pometka != address.pometka) return false;
        if (dataUstanovki != null ? !dataUstanovki.equals(address.dataUstanovki) : address.dataUstanovki != null)
            return false;
        if (nazvanie != null ? !nazvanie.equals(address.nazvanie) : address.nazvanie != null) return false;
        if (adres != null ? !adres.equals(address.adres) : address.adres != null) return false;
        if (eMail != null ? !eMail.equals(address.eMail) : address.eMail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idTochkiObslugivaniya ^ (idTochkiObslugivaniya >>> 32));
        result = 31 * result + (int) (idEmitent ^ (idEmitent >>> 32));
        result = 31 * result + (int) (idFiliala ^ (idFiliala >>> 32));
        result = 31 * result + (dataUstanovki != null ? dataUstanovki.hashCode() : 0);
        result = 31 * result + (nazvanie != null ? nazvanie.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (pometka ? 1 : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        return result;
    }
}
