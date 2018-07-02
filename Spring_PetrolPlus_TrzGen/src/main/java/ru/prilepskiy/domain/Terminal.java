package ru.prilepskiy.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.Arrays;

/**
 * Created by VLADIMIR on 30.05.2018.
 */
@Entity(name="Ecfil030")
@IdClass(TerminalPK.class)
public class Terminal {
    @Id
    private long idEmitent;
    @Id
    private long idFilial;
    @Id
    private long idTo;
    private Time dataUstanovki;
    private String name;
    @Id
    private long nomerTerminala;
    private boolean otmetka;
    private String phone;
    private boolean bankomat;
    private boolean razreshenieOp;
    private Time dataPoslInkass;
    private long kolVoChsBd;
    private long kolVoOpBd;
    private String platformname;
    private long idPrilogeniya;
    private long version;
    private Time dataVer;
    private int timeVer;
    private long procentAll;
    private long procentOp;
    private long procentChs;
    private long krZnOb;
    private long nomerPulaOp;
    private long nomerPulaChs;
    private boolean newTerminal;
    private long krZnOp;
    private long krZnChs;
    private long memoryChs;
    private long memoryOp;
    private long maxMemoryChs;
    private long maxMemoryOp;
    private long memoryChsFromOut;
    private long memoryOpFromOut;
    private boolean memoryOpOverflow;
    private boolean memoryChsOverflow;
    private long algEncode;
    private String eMail;
    private boolean disableForeingSr;
    private boolean dialType;
    private long idCond;
    private long kolVoEmBd;
    private boolean allowClubDefault;
    private String terminalSerialNumber;
    private boolean atoPos;
    private long codeError;

    @Basic
    @Column(name = "ID_EMITENT", nullable = false, precision = 0)
    public long getIdEmitent() {
        return idEmitent;
    }

    public void setIdEmitent(long idEmitent) {
        this.idEmitent = idEmitent;
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
    @Column(name = "ID_TO", nullable = false, precision = 0)
    public long getIdTo() {
        return idTo;
    }

    public void setIdTo(long idTo) {
        this.idTo = idTo;
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
    @Column(name = "NAME", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "OTMETKA", nullable = false, precision = 0)
    public boolean isOtmetka() {
        return otmetka;
    }

    public void setOtmetka(boolean otmetka) {
        this.otmetka = otmetka;
    }

    @Basic
    @Column(name = "PHONE", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "BANKOMAT", nullable = false, precision = 0)
    public boolean isBankomat() {
        return bankomat;
    }

    public void setBankomat(boolean bankomat) {
        this.bankomat = bankomat;
    }

    @Basic
    @Column(name = "RAZRESHENIE_OP", nullable = false, precision = 0)
    public boolean isRazreshenieOp() {
        return razreshenieOp;
    }

    public void setRazreshenieOp(boolean razreshenieOp) {
        this.razreshenieOp = razreshenieOp;
    }

    @Basic
    @Column(name = "DATA_POSL_INKASS", nullable = false)
    public Time getDataPoslInkass() {
        return dataPoslInkass;
    }

    public void setDataPoslInkass(Time dataPoslInkass) {
        this.dataPoslInkass = dataPoslInkass;
    }

    @Basic
    @Column(name = "KOL_VO_CHS_BD", nullable = false, precision = 0)
    public long getKolVoChsBd() {
        return kolVoChsBd;
    }

    public void setKolVoChsBd(long kolVoChsBd) {
        this.kolVoChsBd = kolVoChsBd;
    }

    @Basic
    @Column(name = "KOL_VO_OP_BD", nullable = false, precision = 0)
    public long getKolVoOpBd() {
        return kolVoOpBd;
    }

    public void setKolVoOpBd(long kolVoOpBd) {
        this.kolVoOpBd = kolVoOpBd;
    }

    @Basic
    @Column(name = "PLATFORMNAME", nullable = false, length = 40)
    public String getPlatformname() {
        return platformname;
    }

    public void setPlatformname(String platformname) {
        this.platformname = platformname;
    }

    @Basic
    @Column(name = "ID_PRILOGENIYA", nullable = false, precision = 0)
    public long getIdPrilogeniya() {
        return idPrilogeniya;
    }

    public void setIdPrilogeniya(long idPrilogeniya) {
        this.idPrilogeniya = idPrilogeniya;
    }

    @Basic
    @Column(name = "VERSION", nullable = false, precision = 2)
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Basic
    @Column(name = "DATA_VER", nullable = false)
    public Time getDataVer() {
        return dataVer;
    }

    public void setDataVer(Time dataVer) {
        this.dataVer = dataVer;
    }

    @Basic
    @Column(name = "TIME_VER", nullable = false, precision = 0)
    public int getTimeVer() {
        return timeVer;
    }

    public void setTimeVer(int timeVer) {
        this.timeVer = timeVer;
    }

    @Basic
    @Column(name = "PROCENT_ALL", nullable = false, precision = 0)
    public long getProcentAll() {
        return procentAll;
    }

    public void setProcentAll(long procentAll) {
        this.procentAll = procentAll;
    }

    @Basic
    @Column(name = "PROCENT_OP", nullable = false, precision = 0)
    public long getProcentOp() {
        return procentOp;
    }

    public void setProcentOp(long procentOp) {
        this.procentOp = procentOp;
    }

    @Basic
    @Column(name = "PROCENT_CHS", nullable = false, precision = 0)
    public long getProcentChs() {
        return procentChs;
    }

    public void setProcentChs(long procentChs) {
        this.procentChs = procentChs;
    }

    @Basic
    @Column(name = "KR_ZN_OB", nullable = false, precision = 0)
    public long getKrZnOb() {
        return krZnOb;
    }

    public void setKrZnOb(long krZnOb) {
        this.krZnOb = krZnOb;
    }

    @Basic
    @Column(name = "NOMER_PULA_OP", nullable = false, precision = 0)
    public long getNomerPulaOp() {
        return nomerPulaOp;
    }

    public void setNomerPulaOp(long nomerPulaOp) {
        this.nomerPulaOp = nomerPulaOp;
    }

    @Basic
    @Column(name = "NOMER_PULA_CHS", nullable = false, precision = 0)
    public long getNomerPulaChs() {
        return nomerPulaChs;
    }

    public void setNomerPulaChs(long nomerPulaChs) {
        this.nomerPulaChs = nomerPulaChs;
    }

    @Basic
    @Column(name = "NEW_TERMINAL", nullable = false, precision = 0)
    public boolean isNewTerminal() {
        return newTerminal;
    }

    public void setNewTerminal(boolean newTerminal) {
        this.newTerminal = newTerminal;
    }

    @Basic
    @Column(name = "KR_ZN_OP", nullable = false, precision = 0)
    public long getKrZnOp() {
        return krZnOp;
    }

    public void setKrZnOp(long krZnOp) {
        this.krZnOp = krZnOp;
    }

    @Basic
    @Column(name = "KR_ZN_CHS", nullable = false, precision = 0)
    public long getKrZnChs() {
        return krZnChs;
    }

    public void setKrZnChs(long krZnChs) {
        this.krZnChs = krZnChs;
    }

    @Basic
    @Column(name = "MEMORY_CHS", nullable = false, precision = 0)
    public long getMemoryChs() {
        return memoryChs;
    }

    public void setMemoryChs(long memoryChs) {
        this.memoryChs = memoryChs;
    }

    @Basic
    @Column(name = "MEMORY_OP", nullable = false, precision = 0)
    public long getMemoryOp() {
        return memoryOp;
    }

    public void setMemoryOp(long memoryOp) {
        this.memoryOp = memoryOp;
    }

    @Basic
    @Column(name = "MAX_MEMORY_CHS", nullable = false, precision = 0)
    public long getMaxMemoryChs() {
        return maxMemoryChs;
    }

    public void setMaxMemoryChs(long maxMemoryChs) {
        this.maxMemoryChs = maxMemoryChs;
    }

    @Basic
    @Column(name = "MAX_MEMORY_OP", nullable = false, precision = 0)
    public long getMaxMemoryOp() {
        return maxMemoryOp;
    }

    public void setMaxMemoryOp(long maxMemoryOp) {
        this.maxMemoryOp = maxMemoryOp;
    }

    @Basic
    @Column(name = "MEMORY_CHS_FROM_OUT", nullable = false, precision = 0)
    public long getMemoryChsFromOut() {
        return memoryChsFromOut;
    }

    public void setMemoryChsFromOut(long memoryChsFromOut) {
        this.memoryChsFromOut = memoryChsFromOut;
    }

    @Basic
    @Column(name = "MEMORY_OP_FROM_OUT", nullable = false, precision = 0)
    public long getMemoryOpFromOut() {
        return memoryOpFromOut;
    }

    public void setMemoryOpFromOut(long memoryOpFromOut) {
        this.memoryOpFromOut = memoryOpFromOut;
    }

    @Basic
    @Column(name = "MEMORY_OP_OVERFLOW", nullable = false, precision = 0)
    public boolean isMemoryOpOverflow() {
        return memoryOpOverflow;
    }

    public void setMemoryOpOverflow(boolean memoryOpOverflow) {
        this.memoryOpOverflow = memoryOpOverflow;
    }

    @Basic
    @Column(name = "MEMORY_CHS_OVERFLOW", nullable = false, precision = 0)
    public boolean isMemoryChsOverflow() {
        return memoryChsOverflow;
    }

    public void setMemoryChsOverflow(boolean memoryChsOverflow) {
        this.memoryChsOverflow = memoryChsOverflow;
    }

    @Basic
    @Column(name = "ALG_ENCODE", nullable = false, precision = 0)
    public long getAlgEncode() {
        return algEncode;
    }

    public void setAlgEncode(long algEncode) {
        this.algEncode = algEncode;
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
    @Column(name = "DISABLE_FOREING_SR", nullable = false, precision = 0)
    public boolean isDisableForeingSr() {
        return disableForeingSr;
    }

    public void setDisableForeingSr(boolean disableForeingSr) {
        this.disableForeingSr = disableForeingSr;
    }

    @Basic
    @Column(name = "DIAL_TYPE", nullable = false, precision = 0)
    public boolean isDialType() {
        return dialType;
    }

    public void setDialType(boolean dialType) {
        this.dialType = dialType;
    }

    @Basic
    @Column(name = "ID_COND", nullable = false, precision = 0)
    public long getIdCond() {
        return idCond;
    }

    public void setIdCond(long idCond) {
        this.idCond = idCond;
    }

    @Basic
    @Column(name = "KOL_VO_EM_BD", nullable = false, precision = 0)
    public long getKolVoEmBd() {
        return kolVoEmBd;
    }

    public void setKolVoEmBd(long kolVoEmBd) {
        this.kolVoEmBd = kolVoEmBd;
    }

    @Basic
    @Column(name = "ALLOW_CLUB_DEFAULT", nullable = false, precision = 0)
    public boolean isAllowClubDefault() {
        return allowClubDefault;
    }

    public void setAllowClubDefault(boolean allowClubDefault) {
        this.allowClubDefault = allowClubDefault;
    }

    @Basic
    @Column(name = "TERMINAL_SERIAL_NUMBER", nullable = true, length = 50)
    public String getTerminalSerialNumber() {
        return terminalSerialNumber;
    }

    public void setTerminalSerialNumber(String terminalSerialNumber) {
        this.terminalSerialNumber = terminalSerialNumber;
    }

    @Basic
    @Column(name = "ATO_POS", nullable = false, precision = 0)
    public boolean isAtoPos() {
        return atoPos;
    }

    public void setAtoPos(boolean atoPos) {
        this.atoPos = atoPos;
    }

    @Basic
    @Column(name = "CODE_ERROR", nullable = false, precision = 0)
    public long getCodeError() {
        return codeError;
    }

    public void setCodeError(long codeError) {
        this.codeError = codeError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terminal terminal = (Terminal) o;

        if (idEmitent != terminal.idEmitent) return false;
        if (idFilial != terminal.idFilial) return false;
        if (idTo != terminal.idTo) return false;
        if (nomerTerminala != terminal.nomerTerminala) return false;
        if (otmetka != terminal.otmetka) return false;
        if (bankomat != terminal.bankomat) return false;
        if (razreshenieOp != terminal.razreshenieOp) return false;
        if (kolVoChsBd != terminal.kolVoChsBd) return false;
        if (kolVoOpBd != terminal.kolVoOpBd) return false;
        if (idPrilogeniya != terminal.idPrilogeniya) return false;
        if (version != terminal.version) return false;
        if (timeVer != terminal.timeVer) return false;
        if (procentAll != terminal.procentAll) return false;
        if (procentOp != terminal.procentOp) return false;
        if (procentChs != terminal.procentChs) return false;
        if (krZnOb != terminal.krZnOb) return false;
        if (nomerPulaOp != terminal.nomerPulaOp) return false;
        if (nomerPulaChs != terminal.nomerPulaChs) return false;
        if (newTerminal != terminal.newTerminal) return false;
        if (krZnOp != terminal.krZnOp) return false;
        if (krZnChs != terminal.krZnChs) return false;
        if (memoryChs != terminal.memoryChs) return false;
        if (memoryOp != terminal.memoryOp) return false;
        if (maxMemoryChs != terminal.maxMemoryChs) return false;
        if (maxMemoryOp != terminal.maxMemoryOp) return false;
        if (memoryChsFromOut != terminal.memoryChsFromOut) return false;
        if (memoryOpFromOut != terminal.memoryOpFromOut) return false;
        if (memoryOpOverflow != terminal.memoryOpOverflow) return false;
        if (memoryChsOverflow != terminal.memoryChsOverflow) return false;
        if (algEncode != terminal.algEncode) return false;
        if (disableForeingSr != terminal.disableForeingSr) return false;
        if (dialType != terminal.dialType) return false;
        if (idCond != terminal.idCond) return false;
        if (kolVoEmBd != terminal.kolVoEmBd) return false;
        if (allowClubDefault != terminal.allowClubDefault) return false;
        if (atoPos != terminal.atoPos) return false;
        if (codeError != terminal.codeError) return false;
        if (dataUstanovki != null ? !dataUstanovki.equals(terminal.dataUstanovki) : terminal.dataUstanovki != null)
            return false;
        if (name != null ? !name.equals(terminal.name) : terminal.name != null) return false;
        if (phone != null ? !phone.equals(terminal.phone) : terminal.phone != null) return false;
        if (dataPoslInkass != null ? !dataPoslInkass.equals(terminal.dataPoslInkass) : terminal.dataPoslInkass != null)
            return false;
        if (platformname != null ? !platformname.equals(terminal.platformname) : terminal.platformname != null)
            return false;
        if (dataVer != null ? !dataVer.equals(terminal.dataVer) : terminal.dataVer != null) return false;
        if (eMail != null ? !eMail.equals(terminal.eMail) : terminal.eMail != null) return false;
        if (terminalSerialNumber != null ? !terminalSerialNumber.equals(terminal.terminalSerialNumber) : terminal.terminalSerialNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEmitent ^ (idEmitent >>> 32));
        result = 31 * result + (int) (idFilial ^ (idFilial >>> 32));
        result = 31 * result + (int) (idTo ^ (idTo >>> 32));
        result = 31 * result + (dataUstanovki != null ? dataUstanovki.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (nomerTerminala ^ (nomerTerminala >>> 32));
        result = 31 * result + (otmetka ? 1 : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (bankomat ? 1 : 0);
        result = 31 * result + (razreshenieOp ? 1 : 0);
        result = 31 * result + (dataPoslInkass != null ? dataPoslInkass.hashCode() : 0);
        result = 31 * result + (int) (kolVoChsBd ^ (kolVoChsBd >>> 32));
        result = 31 * result + (int) (kolVoOpBd ^ (kolVoOpBd >>> 32));
        result = 31 * result + (platformname != null ? platformname.hashCode() : 0);
        result = 31 * result + (int) (idPrilogeniya ^ (idPrilogeniya >>> 32));
        result = 31 * result + (int) (version ^ (version >>> 32));
        result = 31 * result + (dataVer != null ? dataVer.hashCode() : 0);
        result = 31 * result + timeVer;
        result = 31 * result + (int) (procentAll ^ (procentAll >>> 32));
        result = 31 * result + (int) (procentOp ^ (procentOp >>> 32));
        result = 31 * result + (int) (procentChs ^ (procentChs >>> 32));
        result = 31 * result + (int) (krZnOb ^ (krZnOb >>> 32));
        result = 31 * result + (int) (nomerPulaOp ^ (nomerPulaOp >>> 32));
        result = 31 * result + (int) (nomerPulaChs ^ (nomerPulaChs >>> 32));
        result = 31 * result + (newTerminal ? 1 : 0);
        result = 31 * result + (int) (krZnOp ^ (krZnOp >>> 32));
        result = 31 * result + (int) (krZnChs ^ (krZnChs >>> 32));
        result = 31 * result + (int) (memoryChs ^ (memoryChs >>> 32));
        result = 31 * result + (int) (memoryOp ^ (memoryOp >>> 32));
        result = 31 * result + (int) (maxMemoryChs ^ (maxMemoryChs >>> 32));
        result = 31 * result + (int) (maxMemoryOp ^ (maxMemoryOp >>> 32));
        result = 31 * result + (int) (memoryChsFromOut ^ (memoryChsFromOut >>> 32));
        result = 31 * result + (int) (memoryOpFromOut ^ (memoryOpFromOut >>> 32));
        result = 31 * result + (memoryOpOverflow ? 1 : 0);
        result = 31 * result + (memoryChsOverflow ? 1 : 0);
        result = 31 * result + (int) (algEncode ^ (algEncode >>> 32));
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (disableForeingSr ? 1 : 0);
        result = 31 * result + (dialType ? 1 : 0);
        result = 31 * result + (int) (idCond ^ (idCond >>> 32));
        result = 31 * result + (int) (kolVoEmBd ^ (kolVoEmBd >>> 32));
        result = 31 * result + (allowClubDefault ? 1 : 0);
        result = 31 * result + (terminalSerialNumber != null ? terminalSerialNumber.hashCode() : 0);
        result = 31 * result + (atoPos ? 1 : 0);
        result = 31 * result + (int) (codeError ^ (codeError >>> 32));
        return result;
    }
}
