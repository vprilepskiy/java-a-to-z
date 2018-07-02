package ru.prilepskiy.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
public class AddressPK implements Serializable {
    private long idTochkiObslugivaniya;
    private long idEmitent;
    private long idFiliala;

    @Column(name = "ID_TOCHKI_OBSLUGIVANIYA", nullable = false, precision = 0)
    @Id
    public long getIdTochkiObslugivaniya() {
        return idTochkiObslugivaniya;
    }

    public void setIdTochkiObslugivaniya(long idTochkiObslugivaniya) {
        this.idTochkiObslugivaniya = idTochkiObslugivaniya;
    }

    @Column(name = "ID_EMITENT", nullable = false, precision = 0)
    @Id
    public long getIdEmitent() {
        return idEmitent;
    }

    public void setIdEmitent(long idEmitent) {
        this.idEmitent = idEmitent;
    }

    @Column(name = "ID_FILIALA", nullable = false, precision = 0)
    @Id
    public long getIdFiliala() {
        return idFiliala;
    }

    public void setIdFiliala(long idFiliala) {
        this.idFiliala = idFiliala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressPK that = (AddressPK) o;

        if (idTochkiObslugivaniya != that.idTochkiObslugivaniya) return false;
        if (idEmitent != that.idEmitent) return false;
        if (idFiliala != that.idFiliala) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idTochkiObslugivaniya ^ (idTochkiObslugivaniya >>> 32));
        result = 31 * result + (int) (idEmitent ^ (idEmitent >>> 32));
        result = 31 * result + (int) (idFiliala ^ (idFiliala >>> 32));
        return result;
    }
}
