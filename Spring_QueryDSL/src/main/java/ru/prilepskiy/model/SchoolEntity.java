package ru.prilepskiy.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Школа.
 */
@Entity
@Table(name = "school")
public class SchoolEntity extends BaseEntity {

    /**
     * Номер.
     */
    @Column
    private Integer number;

    /**
     * Название.
     */
    @Column
    private String name;

    /**
     * Класс.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="school_id")
    private Set<SchoolClassEntity> classes;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SchoolClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(Set<SchoolClassEntity> classes) {
        this.classes = classes;
    }
}
