package ru.prilepskiy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

/**
 * Юр. лица.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Entity(name="Ecfil002")
public class Client {
    @Id
    private long idFirmy;
    private String name;
    private Time dataUdalenia;
    private long idGrTarifaPerescheta;
    private long idBs;
    private long idOkonh;
    private long idPhone;
    private long idFaksa;
    private long idStrany;
    private long idCyti;
    private String adress;
    private String okpo;
    private String primehanie;
    private boolean pometka;
    private String inn;
//    private boolean priznakAvtZanesVCs;
    private short kolKartPoLs;
    private boolean priznakDolgnika;
    private String fioKontLica;
    private String dogovor;
    private boolean nePspPriIzmCen;
    private boolean priznacInformDolgnika;
    private long idAnotherFirm;
    private long idSostoyanya;
    private String eMail;
    private String nameForReport;
    private String kpp;
    private Time dataSuspend;
    private boolean autoBlockMl;
    private boolean mlAlDebtorSign;
    private boolean mlInDebtorSign;
    private String realAddress;
    private long idFirmBuyer;
    private String contractNum;
    private Time contractDate;
    private Long discountedTariffId;
    private String buhJob;
    private String buhName;
    private String manager;
    private String managerRp;
    private String mngDgvr;
    private String mngJob;
    private String mngJobRp;
    private String codeword;
    private String letterTemplate;
    private long idActions;
    private boolean fpByContract;
    private boolean createZeroFp;
//    private long pwsState;
//    private Time pwsDate;
//    private Boolean pwsNeedAnswer;

    @Basic
    @Column(name = "ID_FIRMY", nullable = false, precision = 0)
    public long getIdFirmy() {
        return idFirmy;
    }

    public void setIdFirmy(long idFirmy) {
        this.idFirmy = idFirmy;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DATA_UDALENIA", nullable = false)
    public Time getDataUdalenia() {
        return dataUdalenia;
    }

    public void setDataUdalenia(Time dataUdalenia) {
        this.dataUdalenia = dataUdalenia;
    }

    @Basic
    @Column(name = "ID_GR_TARIFA_PERESCHETA", nullable = false, precision = 0)
    public long getIdGrTarifaPerescheta() {
        return idGrTarifaPerescheta;
    }

    public void setIdGrTarifaPerescheta(long idGrTarifaPerescheta) {
        this.idGrTarifaPerescheta = idGrTarifaPerescheta;
    }

    @Basic
    @Column(name = "ID_BS", nullable = false, precision = 0)
    public long getIdBs() {
        return idBs;
    }

    public void setIdBs(long idBs) {
        this.idBs = idBs;
    }

    @Basic
    @Column(name = "ID_OKONH", nullable = false, precision = 0)
    public long getIdOkonh() {
        return idOkonh;
    }

    public void setIdOkonh(long idOkonh) {
        this.idOkonh = idOkonh;
    }

    @Basic
    @Column(name = "ID_PHONE", nullable = false, precision = 0)
    public long getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(long idPhone) {
        this.idPhone = idPhone;
    }

    @Basic
    @Column(name = "ID_FAKSA", nullable = false, precision = 0)
    public long getIdFaksa() {
        return idFaksa;
    }

    public void setIdFaksa(long idFaksa) {
        this.idFaksa = idFaksa;
    }

    @Basic
    @Column(name = "ID_STRANY", nullable = false, precision = 0)
    public long getIdStrany() {
        return idStrany;
    }

    public void setIdStrany(long idStrany) {
        this.idStrany = idStrany;
    }

    @Basic
    @Column(name = "ID_CYTI", nullable = false, precision = 0)
    public long getIdCyti() {
        return idCyti;
    }

    public void setIdCyti(long idCyti) {
        this.idCyti = idCyti;
    }

    @Basic
    @Column(name = "ADRESS", nullable = false, length = 100)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "OKPO", nullable = false, length = 10)
    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    @Basic
    @Column(name = "PRIMEHANIE", nullable = false, length = 100)
    public String getPrimehanie() {
        return primehanie;
    }

    public void setPrimehanie(String primehanie) {
        this.primehanie = primehanie;
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
    @Column(name = "INN", nullable = false, length = 30)
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

//    @Basic
//    @Column(name = "PRIZNAK_AVT_ZANES_V_CS", nullable = false, precision = 0)
//    public boolean isPriznakAvtZanesVCs() {
//        return priznakAvtZanesVCs;
//    }
//
//    public void setPriznakAvtZanesVCs(boolean priznakAvtZanesVCs) {
//        this.priznakAvtZanesVCs = priznakAvtZanesVCs;
//    }

    @Basic
    @Column(name = "KOL_KART_PO_LS", nullable = false, precision = 0)
    public short getKolKartPoLs() {
        return kolKartPoLs;
    }

    public void setKolKartPoLs(short kolKartPoLs) {
        this.kolKartPoLs = kolKartPoLs;
    }

    @Basic
    @Column(name = "PRIZNAK_DOLGNIKA", nullable = false, precision = 0)
    public boolean isPriznakDolgnika() {
        return priznakDolgnika;
    }

    public void setPriznakDolgnika(boolean priznakDolgnika) {
        this.priznakDolgnika = priznakDolgnika;
    }

    @Basic
    @Column(name = "FIO_KONT_LICA", nullable = false, length = 40)
    public String getFioKontLica() {
        return fioKontLica;
    }

    public void setFioKontLica(String fioKontLica) {
        this.fioKontLica = fioKontLica;
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
    @Column(name = "NE_PSP_PRI_IZM_CEN", nullable = false, precision = 0)
    public boolean isNePspPriIzmCen() {
        return nePspPriIzmCen;
    }

    public void setNePspPriIzmCen(boolean nePspPriIzmCen) {
        this.nePspPriIzmCen = nePspPriIzmCen;
    }

    @Basic
    @Column(name = "PRIZNAC_INFORM_DOLGNIKA", nullable = false, precision = 0)
    public boolean isPriznacInformDolgnika() {
        return priznacInformDolgnika;
    }

    public void setPriznacInformDolgnika(boolean priznacInformDolgnika) {
        this.priznacInformDolgnika = priznacInformDolgnika;
    }

    @Basic
    @Column(name = "ID_ANOTHER_FIRM", nullable = false, precision = 0)
    public long getIdAnotherFirm() {
        return idAnotherFirm;
    }

    public void setIdAnotherFirm(long idAnotherFirm) {
        this.idAnotherFirm = idAnotherFirm;
    }

    @Basic
    @Column(name = "ID_SOSTOYANYA", nullable = false, precision = 0)
    public long getIdSostoyanya() {
        return idSostoyanya;
    }

    public void setIdSostoyanya(long idSostoyanya) {
        this.idSostoyanya = idSostoyanya;
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
    @Column(name = "NAME_FOR_REPORT", nullable = false, length = 255)
    public String getNameForReport() {
        return nameForReport;
    }

    public void setNameForReport(String nameForReport) {
        this.nameForReport = nameForReport;
    }

    @Basic
    @Column(name = "KPP", nullable = false, length = 20)
    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    @Basic
    @Column(name = "DATA_SUSPEND", nullable = false)
    public Time getDataSuspend() {
        return dataSuspend;
    }

    public void setDataSuspend(Time dataSuspend) {
        this.dataSuspend = dataSuspend;
    }

    @Basic
    @Column(name = "AUTO_BLOCK_ML", nullable = false, precision = 0)
    public boolean isAutoBlockMl() {
        return autoBlockMl;
    }

    public void setAutoBlockMl(boolean autoBlockMl) {
        this.autoBlockMl = autoBlockMl;
    }

    @Basic
    @Column(name = "ML_AL_DEBTOR_SIGN", nullable = false, precision = 0)
    public boolean isMlAlDebtorSign() {
        return mlAlDebtorSign;
    }

    public void setMlAlDebtorSign(boolean mlAlDebtorSign) {
        this.mlAlDebtorSign = mlAlDebtorSign;
    }

    @Basic
    @Column(name = "ML_IN_DEBTOR_SIGN", nullable = false, precision = 0)
    public boolean isMlInDebtorSign() {
        return mlInDebtorSign;
    }

    public void setMlInDebtorSign(boolean mlInDebtorSign) {
        this.mlInDebtorSign = mlInDebtorSign;
    }

    @Basic
    @Column(name = "REAL_ADDRESS", nullable = false, length = 100)
    public String getRealAddress() {
        return realAddress;
    }

    public void setRealAddress(String realAddress) {
        this.realAddress = realAddress;
    }

    @Basic
    @Column(name = "ID_FIRM_BUYER", nullable = false, precision = 0)
    public long getIdFirmBuyer() {
        return idFirmBuyer;
    }

    public void setIdFirmBuyer(long idFirmBuyer) {
        this.idFirmBuyer = idFirmBuyer;
    }

    @Basic
    @Column(name = "CONTRACT_NUM", nullable = false, length = 70)
    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    @Basic
    @Column(name = "CONTRACT_DATE", nullable = true)
    public Time getContractDate() {
        return contractDate;
    }

    public void setContractDate(Time contractDate) {
        this.contractDate = contractDate;
    }

    @Basic
    @Column(name = "DISCOUNTED_TARIFF_ID", nullable = true, precision = 0)
    public Long getDiscountedTariffId() {
        return discountedTariffId;
    }

    public void setDiscountedTariffId(Long discountedTariffId) {
        this.discountedTariffId = discountedTariffId;
    }

    @Basic
    @Column(name = "BUH_JOB", nullable = true, length = 200)
    public String getBuhJob() {
        return buhJob;
    }

    public void setBuhJob(String buhJob) {
        this.buhJob = buhJob;
    }

    @Basic
    @Column(name = "BUH_NAME", nullable = true, length = 200)
    public String getBuhName() {
        return buhName;
    }

    public void setBuhName(String buhName) {
        this.buhName = buhName;
    }

    @Basic
    @Column(name = "MANAGER", nullable = true, length = 200)
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Basic
    @Column(name = "MANAGER_RP", nullable = true, length = 200)
    public String getManagerRp() {
        return managerRp;
    }

    public void setManagerRp(String managerRp) {
        this.managerRp = managerRp;
    }

    @Basic
    @Column(name = "MNG_DGVR", nullable = true, length = 200)
    public String getMngDgvr() {
        return mngDgvr;
    }

    public void setMngDgvr(String mngDgvr) {
        this.mngDgvr = mngDgvr;
    }

    @Basic
    @Column(name = "MNG_JOB", nullable = true, length = 200)
    public String getMngJob() {
        return mngJob;
    }

    public void setMngJob(String mngJob) {
        this.mngJob = mngJob;
    }

    @Basic
    @Column(name = "MNG_JOB_RP", nullable = true, length = 200)
    public String getMngJobRp() {
        return mngJobRp;
    }

    public void setMngJobRp(String mngJobRp) {
        this.mngJobRp = mngJobRp;
    }

    @Basic
    @Column(name = "CODEWORD", nullable = true, length = 32)
    public String getCodeword() {
        return codeword;
    }

    public void setCodeword(String codeword) {
        this.codeword = codeword;
    }

    @Basic
    @Column(name = "LETTER_TEMPLATE", nullable = true, length = 4000)
    public String getLetterTemplate() {
        return letterTemplate;
    }

    public void setLetterTemplate(String letterTemplate) {
        this.letterTemplate = letterTemplate;
    }

    @Basic
    @Column(name = "ID_ACTIONS", nullable = false, precision = 0)
    public long getIdActions() {
        return idActions;
    }

    public void setIdActions(long idActions) {
        this.idActions = idActions;
    }

    @Basic
    @Column(name = "FP_BY_CONTRACT", nullable = false, precision = 0)
    public boolean isFpByContract() {
        return fpByContract;
    }

    public void setFpByContract(boolean fpByContract) {
        this.fpByContract = fpByContract;
    }

    @Basic
    @Column(name = "CREATE_ZERO_FP", nullable = false, precision = 0)
    public boolean isCreateZeroFp() {
        return createZeroFp;
    }

    public void setCreateZeroFp(boolean createZeroFp) {
        this.createZeroFp = createZeroFp;
    }

//    @Basic
//    @Column(name = "PWS_STATE", nullable = false, precision = 0)
//    public long getPwsState() {
//        return pwsState;
//    }
//
//    public void setPwsState(long pwsState) {
//        this.pwsState = pwsState;
//    }
//
//    @Basic
//    @Column(name = "PWS_DATE", nullable = true)
//    public Time getPwsDate() {
//        return pwsDate;
//    }
//
//    public void setPwsDate(Time pwsDate) {
//        this.pwsDate = pwsDate;
//    }
//
//    @Basic
//    @Column(name = "PWS_NEED_ANSWER", nullable = true, precision = 0)
//    public Boolean getPwsNeedAnswer() {
//        return pwsNeedAnswer;
//    }
//
//    public void setPwsNeedAnswer(Boolean pwsNeedAnswer) {
//        this.pwsNeedAnswer = pwsNeedAnswer;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idFirmy != client.idFirmy) return false;
        if (idGrTarifaPerescheta != client.idGrTarifaPerescheta) return false;
        if (idBs != client.idBs) return false;
        if (idOkonh != client.idOkonh) return false;
        if (idPhone != client.idPhone) return false;
        if (idFaksa != client.idFaksa) return false;
        if (idStrany != client.idStrany) return false;
        if (idCyti != client.idCyti) return false;
        if (pometka != client.pometka) return false;
//        if (priznakAvtZanesVCs != client.priznakAvtZanesVCs) return false;
        if (kolKartPoLs != client.kolKartPoLs) return false;
        if (priznakDolgnika != client.priznakDolgnika) return false;
        if (nePspPriIzmCen != client.nePspPriIzmCen) return false;
        if (priznacInformDolgnika != client.priznacInformDolgnika) return false;
        if (idAnotherFirm != client.idAnotherFirm) return false;
        if (idSostoyanya != client.idSostoyanya) return false;
        if (autoBlockMl != client.autoBlockMl) return false;
        if (mlAlDebtorSign != client.mlAlDebtorSign) return false;
        if (mlInDebtorSign != client.mlInDebtorSign) return false;
        if (idFirmBuyer != client.idFirmBuyer) return false;
        if (idActions != client.idActions) return false;
        if (fpByContract != client.fpByContract) return false;
        if (createZeroFp != client.createZeroFp) return false;
//        if (pwsState != client.pwsState) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (dataUdalenia != null ? !dataUdalenia.equals(client.dataUdalenia) : client.dataUdalenia != null)
            return false;
        if (adress != null ? !adress.equals(client.adress) : client.adress != null) return false;
        if (okpo != null ? !okpo.equals(client.okpo) : client.okpo != null) return false;
        if (primehanie != null ? !primehanie.equals(client.primehanie) : client.primehanie != null) return false;
        if (inn != null ? !inn.equals(client.inn) : client.inn != null) return false;
        if (fioKontLica != null ? !fioKontLica.equals(client.fioKontLica) : client.fioKontLica != null)
            return false;
        if (dogovor != null ? !dogovor.equals(client.dogovor) : client.dogovor != null) return false;
        if (eMail != null ? !eMail.equals(client.eMail) : client.eMail != null) return false;
        if (nameForReport != null ? !nameForReport.equals(client.nameForReport) : client.nameForReport != null)
            return false;
        if (kpp != null ? !kpp.equals(client.kpp) : client.kpp != null) return false;
        if (dataSuspend != null ? !dataSuspend.equals(client.dataSuspend) : client.dataSuspend != null)
            return false;
        if (realAddress != null ? !realAddress.equals(client.realAddress) : client.realAddress != null)
            return false;
        if (contractNum != null ? !contractNum.equals(client.contractNum) : client.contractNum != null)
            return false;
        if (contractDate != null ? !contractDate.equals(client.contractDate) : client.contractDate != null)
            return false;
        if (discountedTariffId != null ? !discountedTariffId.equals(client.discountedTariffId) : client.discountedTariffId != null)
            return false;
        if (buhJob != null ? !buhJob.equals(client.buhJob) : client.buhJob != null) return false;
        if (buhName != null ? !buhName.equals(client.buhName) : client.buhName != null) return false;
        if (manager != null ? !manager.equals(client.manager) : client.manager != null) return false;
        if (managerRp != null ? !managerRp.equals(client.managerRp) : client.managerRp != null) return false;
        if (mngDgvr != null ? !mngDgvr.equals(client.mngDgvr) : client.mngDgvr != null) return false;
        if (mngJob != null ? !mngJob.equals(client.mngJob) : client.mngJob != null) return false;
        if (mngJobRp != null ? !mngJobRp.equals(client.mngJobRp) : client.mngJobRp != null) return false;
        if (codeword != null ? !codeword.equals(client.codeword) : client.codeword != null) return false;
        if (letterTemplate != null ? !letterTemplate.equals(client.letterTemplate) : client.letterTemplate != null)
            return false;
//        if (pwsDate != null ? !pwsDate.equals(client.pwsDate) : client.pwsDate != null) return false;
//        if (pwsNeedAnswer != null ? !pwsNeedAnswer.equals(client.pwsNeedAnswer) : client.pwsNeedAnswer != null)
//            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idFirmy ^ (idFirmy >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dataUdalenia != null ? dataUdalenia.hashCode() : 0);
        result = 31 * result + (int) (idGrTarifaPerescheta ^ (idGrTarifaPerescheta >>> 32));
        result = 31 * result + (int) (idBs ^ (idBs >>> 32));
        result = 31 * result + (int) (idOkonh ^ (idOkonh >>> 32));
        result = 31 * result + (int) (idPhone ^ (idPhone >>> 32));
        result = 31 * result + (int) (idFaksa ^ (idFaksa >>> 32));
        result = 31 * result + (int) (idStrany ^ (idStrany >>> 32));
        result = 31 * result + (int) (idCyti ^ (idCyti >>> 32));
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (okpo != null ? okpo.hashCode() : 0);
        result = 31 * result + (primehanie != null ? primehanie.hashCode() : 0);
        result = 31 * result + (pometka ? 1 : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
//        result = 31 * result + (priznakAvtZanesVCs ? 1 : 0);
        result = 31 * result + (int) kolKartPoLs;
        result = 31 * result + (priznakDolgnika ? 1 : 0);
        result = 31 * result + (fioKontLica != null ? fioKontLica.hashCode() : 0);
        result = 31 * result + (dogovor != null ? dogovor.hashCode() : 0);
        result = 31 * result + (nePspPriIzmCen ? 1 : 0);
        result = 31 * result + (priznacInformDolgnika ? 1 : 0);
        result = 31 * result + (int) (idAnotherFirm ^ (idAnotherFirm >>> 32));
        result = 31 * result + (int) (idSostoyanya ^ (idSostoyanya >>> 32));
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (nameForReport != null ? nameForReport.hashCode() : 0);
        result = 31 * result + (kpp != null ? kpp.hashCode() : 0);
        result = 31 * result + (dataSuspend != null ? dataSuspend.hashCode() : 0);
        result = 31 * result + (autoBlockMl ? 1 : 0);
        result = 31 * result + (mlAlDebtorSign ? 1 : 0);
        result = 31 * result + (mlInDebtorSign ? 1 : 0);
        result = 31 * result + (realAddress != null ? realAddress.hashCode() : 0);
        result = 31 * result + (int) (idFirmBuyer ^ (idFirmBuyer >>> 32));
        result = 31 * result + (contractNum != null ? contractNum.hashCode() : 0);
        result = 31 * result + (contractDate != null ? contractDate.hashCode() : 0);
        result = 31 * result + (discountedTariffId != null ? discountedTariffId.hashCode() : 0);
        result = 31 * result + (buhJob != null ? buhJob.hashCode() : 0);
        result = 31 * result + (buhName != null ? buhName.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (managerRp != null ? managerRp.hashCode() : 0);
        result = 31 * result + (mngDgvr != null ? mngDgvr.hashCode() : 0);
        result = 31 * result + (mngJob != null ? mngJob.hashCode() : 0);
        result = 31 * result + (mngJobRp != null ? mngJobRp.hashCode() : 0);
        result = 31 * result + (codeword != null ? codeword.hashCode() : 0);
        result = 31 * result + (letterTemplate != null ? letterTemplate.hashCode() : 0);
        result = 31 * result + (int) (idActions ^ (idActions >>> 32));
        result = 31 * result + (fpByContract ? 1 : 0);
        result = 31 * result + (createZeroFp ? 1 : 0);
//        result = 31 * result + (int) (pwsState ^ (pwsState >>> 32));
//        result = 31 * result + (pwsDate != null ? pwsDate.hashCode() : 0);
//        result = 31 * result + (pwsNeedAnswer != null ? pwsNeedAnswer.hashCode() : 0);
        return result;
    }
}
