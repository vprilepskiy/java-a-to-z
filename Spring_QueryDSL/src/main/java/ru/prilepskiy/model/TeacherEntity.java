package ru.prilepskiy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Учитель.
 */
@Entity
@Table(name = "teacher")
public class TeacherEntity extends PeopleEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_school_class",
        joinColumns = {
            @JoinColumn(name = "teacher_id", nullable = false, updatable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(name = "school_class_id", nullable = false, updatable = false)
        }
    )
    private Set<SchoolClassEntity> classes;

    public Set<SchoolClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(Set<SchoolClassEntity> classes) {
        this.classes = classes;
    }
}
