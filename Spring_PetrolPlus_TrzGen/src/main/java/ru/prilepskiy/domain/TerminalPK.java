package ru.prilepskiy.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by VLADIMIR on 30.05.2018.
 */
public class TerminalPK implements Serializable {
    @Id
    private long idEmitent;
    @Id
    private long idFilial;
    @Id
    private long idTo;
    @Id
    private long nomerTerminala;


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
    @Column(name = "NOMER_TERMINALA", nullable = false, precision = 0)
    public long getNomerTerminala() {
        return nomerTerminala;
    }

    public void setNomerTerminala(long nomerTerminala) {
        this.nomerTerminala = nomerTerminala;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TerminalPK terminal = (TerminalPK) o;

        if (idEmitent != terminal.idEmitent) return false;
        if (idFilial != terminal.idFilial) return false;
        if (idTo != terminal.idTo) return false;
        if (nomerTerminala != terminal.nomerTerminala) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEmitent ^ (idEmitent >>> 32));
        result = 31 * result + (int) (idFilial ^ (idFilial >>> 32));
        result = 31 * result + (int) (idTo ^ (idTo >>> 32));
        result = 31 * result + (int) (nomerTerminala ^ (nomerTerminala >>> 32));
        return result;
    }
}
