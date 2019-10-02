package ru.prilepskiy.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Ученик.
 */
@Entity
@Table(name = "student")
public class StudentEntity extends PeopleEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="school_class_id")
    private SchoolClassEntity schoolClass;

    public SchoolClassEntity getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClassEntity schoolClass) {
        this.schoolClass = schoolClass;
    }
}
