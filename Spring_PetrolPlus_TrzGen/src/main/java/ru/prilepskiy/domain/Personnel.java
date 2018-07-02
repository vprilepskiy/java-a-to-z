package ru.prilepskiy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

/**
 * Персонал.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Entity(name="Ecfil025")
public class Personnel {
    private long idCheloveka;
    private String fIO;
    private String familiya;
    private String imya;
    private String otchestvo;
    private Time dataUvolneniya;
    private long idTelefona;
    private long idCountry;
    private long idSity;
    private long idDoljnosti;
    private String adres;
    private String primechanie;
    private String inn;
    private String dogovor;
    private String pasportnyeDannye;
    private String prichinaUvolneniya;
    private String failPhoto;
    private long idUrovnyaDostupa;
    private boolean pometka;
    private String eMail;
    private String personHash;

    @Id
    @Column(name = "ID_CHELOVEKA", nullable = false, precision = 0)
    public long getIdCheloveka() {
        return idCheloveka;
    }

    public void setIdCheloveka(long idCheloveka) {
        this.idCheloveka = idCheloveka;
    }

    @Basic
    @Column(name = "F_I_O", nullable = false, length = 40)
    public String getfIO() {
        return fIO;
    }

    public void setfIO(String fIO) {
        this.fIO = fIO;
    }

    @Basic
    @Column(name = "FAMILIYA", nullable = false, length = 40)
    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    @Basic
    @Column(name = "IMYA", nullable = false, length = 40)
    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    @Basic
    @Column(name = "OTCHESTVO", nullable = false, length = 40)
    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    @Basic
    @Column(name = "DATA_UVOLNENIYA", nullable = false)
    public Time getDataUvolneniya() {
        return dataUvolneniya;
    }

    public void setDataUvolneniya(Time dataUvolneniya) {
        this.dataUvolneniya = dataUvolneniya;
    }

    @Basic
    @Column(name = "ID_TELEFONA", nullable = false, precision = 0)
    public long getIdTelefona() {
        return idTelefona;
    }

    public void setIdTelefona(long idTelefona) {
        this.idTelefona = idTelefona;
    }

    @Basic
    @Column(name = "ID_COUNTRY", nullable = false, precision = 0)
    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    @Basic
    @Column(name = "ID_SITY", nullable = false, precision = 0)
    public long getIdSity() {
        return idSity;
    }

    public void setIdSity(long idSity) {
        this.idSity = idSity;
    }

    @Basic
    @Column(name = "ID_DOLJNOSTI", nullable = false, precision = 0)
    public long getIdDoljnosti() {
        return idDoljnosti;
    }

    public void setIdDoljnosti(long idDoljnosti) {
        this.idDoljnosti = idDoljnosti;
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
    @Column(name = "PRIMECHANIE", nullable = false, length = 100)
    public String getPrimechanie() {
        return primechanie;
    }

    public void setPrimechanie(String primechanie) {
        this.primechanie = primechanie;
    }

    @Basic
    @Column(name = "INN", nullable = false, length = 30)
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "DOGOVOR", nullable = false, length = 40)
    public String getDogovor() {
        return dogovor;
    }

    public void setDogovor(String dogovor) {
        this.dogovor = dogovor;
    }

    @Basic
    @Column(name = "PASPORTNYE_DANNYE", nullable = false, length = 100)
    public String getPasportnyeDannye() {
        return pasportnyeDannye;
    }

    public void setPasportnyeDannye(String pasportnyeDannye) {
        this.pasportnyeDannye = pasportnyeDannye;
    }

    @Basic
    @Column(name = "PRICHINA_UVOLNENIYA", nullable = false, length = 40)
    public String getPrichinaUvolneniya() {
        return prichinaUvolneniya;
    }

    public void setPrichinaUvolneniya(String prichinaUvolneniya) {
        this.prichinaUvolneniya = prichinaUvolneniya;
    }

    @Basic
    @Column(name = "FAIL_PHOTO", nullable = false, length = 100)
    public String getFailPhoto() {
        return failPhoto;
    }

    public void setFailPhoto(String failPhoto) {
        this.failPhoto = failPhoto;
    }

    @Basic
    @Column(name = "ID_UROVNYA_DOSTUPA", nullable = false, precision = 0)
    public long getIdUrovnyaDostupa() {
        return idUrovnyaDostupa;
    }

    public void setIdUrovnyaDostupa(long idUrovnyaDostupa) {
        this.idUrovnyaDostupa = idUrovnyaDostupa;
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

    @Basic
    @Column(name = "PERSON_HASH", nullable = true, length = 16)
    public String getPersonHash() {
        return personHash;
    }

    public void setPersonHash(String personHash) {
        this.personHash = personHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personnel personnel = (Personnel) o;

        if (idCheloveka != personnel.idCheloveka) return false;
        if (idTelefona != personnel.idTelefona) return false;
        if (idCountry != personnel.idCountry) return false;
        if (idSity != personnel.idSity) return false;
        if (idDoljnosti != personnel.idDoljnosti) return false;
        if (idUrovnyaDostupa != personnel.idUrovnyaDostupa) return false;
        if (pometka != personnel.pometka) return false;
        if (fIO != null ? !fIO.equals(personnel.fIO) : personnel.fIO != null) return false;
        if (familiya != null ? !familiya.equals(personnel.familiya) : personnel.familiya != null) return false;
        if (imya != null ? !imya.equals(personnel.imya) : personnel.imya != null) return false;
        if (otchestvo != null ? !otchestvo.equals(personnel.otchestvo) : personnel.otchestvo != null) return false;
        if (dataUvolneniya != null ? !dataUvolneniya.equals(personnel.dataUvolneniya) : personnel.dataUvolneniya != null)
            return false;
        if (adres != null ? !adres.equals(personnel.adres) : personnel.adres != null) return false;
        if (primechanie != null ? !primechanie.equals(personnel.primechanie) : personnel.primechanie != null)
            return false;
        if (inn != null ? !inn.equals(personnel.inn) : personnel.inn != null) return false;
        if (dogovor != null ? !dogovor.equals(personnel.dogovor) : personnel.dogovor != null) return false;
        if (pasportnyeDannye != null ? !pasportnyeDannye.equals(personnel.pasportnyeDannye) : personnel.pasportnyeDannye != null)
            return false;
        if (prichinaUvolneniya != null ? !prichinaUvolneniya.equals(personnel.prichinaUvolneniya) : personnel.prichinaUvolneniya != null)
            return false;
        if (failPhoto != null ? !failPhoto.equals(personnel.failPhoto) : personnel.failPhoto != null) return false;
        if (eMail != null ? !eMail.equals(personnel.eMail) : personnel.eMail != null) return false;
        if (personHash != null ? !personHash.equals(personnel.personHash) : personnel.personHash != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCheloveka ^ (idCheloveka >>> 32));
        result = 31 * result + (fIO != null ? fIO.hashCode() : 0);
        result = 31 * result + (familiya != null ? familiya.hashCode() : 0);
        result = 31 * result + (imya != null ? imya.hashCode() : 0);
        result = 31 * result + (otchestvo != null ? otchestvo.hashCode() : 0);
        result = 31 * result + (dataUvolneniya != null ? dataUvolneniya.hashCode() : 0);
        result = 31 * result + (int) (idTelefona ^ (idTelefona >>> 32));
        result = 31 * result + (int) (idCountry ^ (idCountry >>> 32));
        result = 31 * result + (int) (idSity ^ (idSity >>> 32));
        result = 31 * result + (int) (idDoljnosti ^ (idDoljnosti >>> 32));
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (primechanie != null ? primechanie.hashCode() : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (dogovor != null ? dogovor.hashCode() : 0);
        result = 31 * result + (pasportnyeDannye != null ? pasportnyeDannye.hashCode() : 0);
        result = 31 * result + (prichinaUvolneniya != null ? prichinaUvolneniya.hashCode() : 0);
        result = 31 * result + (failPhoto != null ? failPhoto.hashCode() : 0);
        result = 31 * result + (int) (idUrovnyaDostupa ^ (idUrovnyaDostupa >>> 32));
        result = 31 * result + (pometka ? 1 : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (personHash != null ? personHash.hashCode() : 0);
        return result;
    }
}
