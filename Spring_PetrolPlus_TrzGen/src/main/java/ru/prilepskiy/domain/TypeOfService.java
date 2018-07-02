package ru.prilepskiy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Название услуг.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Entity(name="Ecfil001")
public class TypeOfService {
    private long idUslugi;
    private String edIzmereniya;
    private String nazvanieUslugi;
    private boolean activnost;
    private String unitLetter;
    private String unitReducedName;
    private boolean allowSubunits;
    private boolean askQuantitySeveralTimes;
    private boolean isCurrency;
    private String sname;
    private byte nds;
    private boolean include;
    private boolean ractive;
    private boolean ibs;
    private int serviceCode;
    private Long exciseDuty;
    private String smlmeasurement;

    @Id
    @Column(name = "ID_USLUGI", nullable = false, precision = 0)
    public long getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(long idUslugi) {
        this.idUslugi = idUslugi;
    }

    @Basic
    @Column(name = "ED_IZMERENIYA", nullable = false, length = 10)
    public String getEdIzmereniya() {
        return edIzmereniya;
    }

    public void setEdIzmereniya(String edIzmereniya) {
        this.edIzmereniya = edIzmereniya;
    }

    @Basic
    @Column(name = "NAZVANIE_USLUGI", nullable = false, length = 40)
    public String getNazvanieUslugi() {
        return nazvanieUslugi;
    }

    public void setNazvanieUslugi(String nazvanieUslugi) {
        this.nazvanieUslugi = nazvanieUslugi;
    }

    @Basic
    @Column(name = "ACTIVNOST", nullable = false, precision = 0)
    public boolean isActivnost() {
        return activnost;
    }

    public void setActivnost(boolean activnost) {
        this.activnost = activnost;
    }

    @Basic
    @Column(name = "UNIT_LETTER", nullable = false, length = 2)
    public String getUnitLetter() {
        return unitLetter;
    }

    public void setUnitLetter(String unitLetter) {
        this.unitLetter = unitLetter;
    }

    @Basic
    @Column(name = "UNIT_REDUCED_NAME", nullable = false, length = 3)
    public String getUnitReducedName() {
        return unitReducedName;
    }

    public void setUnitReducedName(String unitReducedName) {
        this.unitReducedName = unitReducedName;
    }

    @Basic
    @Column(name = "ALLOW_SUBUNITS", nullable = false, precision = 0)
    public boolean isAllowSubunits() {
        return allowSubunits;
    }

    public void setAllowSubunits(boolean allowSubunits) {
        this.allowSubunits = allowSubunits;
    }

    @Basic
    @Column(name = "ASK_QUANTITY_SEVERAL_TIMES", nullable = false, precision = 0)
    public boolean isAskQuantitySeveralTimes() {
        return askQuantitySeveralTimes;
    }

    public void setAskQuantitySeveralTimes(boolean askQuantitySeveralTimes) {
        this.askQuantitySeveralTimes = askQuantitySeveralTimes;
    }

    @Basic
    @Column(name = "IS_CURRENCY", nullable = false, precision = 0)
    public boolean isCurrency() {
        return isCurrency;
    }

    public void setCurrency(boolean currency) {
        isCurrency = currency;
    }

    @Basic
    @Column(name = "SNAME", nullable = true, length = 60)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "NDS", nullable = false, precision = 0)
    public byte getNds() {
        return nds;
    }

    public void setNds(byte nds) {
        this.nds = nds;
    }

    @Basic
    @Column(name = "INCLUDE", nullable = false, precision = 0)
    public boolean isInclude() {
        return include;
    }

    public void setInclude(boolean include) {
        this.include = include;
    }

    @Basic
    @Column(name = "RACTIVE", nullable = false, precision = 0)
    public boolean isRactive() {
        return ractive;
    }

    public void setRactive(boolean ractive) {
        this.ractive = ractive;
    }

    @Basic
    @Column(name = "IBS", nullable = false, precision = 0)
    public boolean isIbs() {
        return ibs;
    }

    public void setIbs(boolean ibs) {
        this.ibs = ibs;
    }

    @Basic
    @Column(name = "SERVICE_CODE", nullable = false, precision = 0)
    public int getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Basic
    @Column(name = "EXCISE_DUTY", nullable = true, precision = 2)
    public Long getExciseDuty() {
        return exciseDuty;
    }

    public void setExciseDuty(Long exciseDuty) {
        this.exciseDuty = exciseDuty;
    }

    @Basic
    @Column(name = "SMLMEASUREMENT", nullable = true, length = 10)
    public String getSmlmeasurement() {
        return smlmeasurement;
    }

    public void setSmlmeasurement(String smlmeasurement) {
        this.smlmeasurement = smlmeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeOfService typeOfService = (TypeOfService) o;

        if (idUslugi != typeOfService.idUslugi) return false;
        if (activnost != typeOfService.activnost) return false;
        if (allowSubunits != typeOfService.allowSubunits) return false;
        if (askQuantitySeveralTimes != typeOfService.askQuantitySeveralTimes) return false;
        if (isCurrency != typeOfService.isCurrency) return false;
        if (nds != typeOfService.nds) return false;
        if (include != typeOfService.include) return false;
        if (ractive != typeOfService.ractive) return false;
        if (ibs != typeOfService.ibs) return false;
        if (serviceCode != typeOfService.serviceCode) return false;
        if (edIzmereniya != null ? !edIzmereniya.equals(typeOfService.edIzmereniya) : typeOfService.edIzmereniya != null)
            return false;
        if (nazvanieUslugi != null ? !nazvanieUslugi.equals(typeOfService.nazvanieUslugi) : typeOfService.nazvanieUslugi != null)
            return false;
        if (unitLetter != null ? !unitLetter.equals(typeOfService.unitLetter) : typeOfService.unitLetter != null) return false;
        if (unitReducedName != null ? !unitReducedName.equals(typeOfService.unitReducedName) : typeOfService.unitReducedName != null)
            return false;
        if (sname != null ? !sname.equals(typeOfService.sname) : typeOfService.sname != null) return false;
        if (exciseDuty != null ? !exciseDuty.equals(typeOfService.exciseDuty) : typeOfService.exciseDuty != null) return false;
        if (smlmeasurement != null ? !smlmeasurement.equals(typeOfService.smlmeasurement) : typeOfService.smlmeasurement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUslugi ^ (idUslugi >>> 32));
        result = 31 * result + (edIzmereniya != null ? edIzmereniya.hashCode() : 0);
        result = 31 * result + (nazvanieUslugi != null ? nazvanieUslugi.hashCode() : 0);
        result = 31 * result + (activnost ? 1 : 0);
        result = 31 * result + (unitLetter != null ? unitLetter.hashCode() : 0);
        result = 31 * result + (unitReducedName != null ? unitReducedName.hashCode() : 0);
        result = 31 * result + (allowSubunits ? 1 : 0);
        result = 31 * result + (askQuantitySeveralTimes ? 1 : 0);
        result = 31 * result + (isCurrency ? 1 : 0);
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (int) nds;
        result = 31 * result + (include ? 1 : 0);
        result = 31 * result + (ractive ? 1 : 0);
        result = 31 * result + (ibs ? 1 : 0);
        result = 31 * result + serviceCode;
        result = 31 * result + (exciseDuty != null ? exciseDuty.hashCode() : 0);
        result = 31 * result + (smlmeasurement != null ? smlmeasurement.hashCode() : 0);
        return result;
    }
}
