package ru.prilepskiy.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Класс.
 */
@Entity
@Table(name = "school_class")
public class SchoolClassEntity extends BaseEntity {

    /**
     * Номер.
     */
    @Column
    private Integer grade;

    /**
     * Буква.
     */
    @Column
    private String character;

    /**
     * Школа.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="school_id")
    private SchoolEntity school;

    /**
     * Учителя.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_school_class",
        joinColumns = {
            @JoinColumn(name = "school_class_id", nullable = false, updatable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(name = "teacher_id", nullable = false, updatable = false)
        }
    )
    private Set<TeacherEntity> teachers;

    /**
     * Ученики.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="school_class_id")
    private Set<StudentEntity> students;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public SchoolEntity getSchool() {
        return school;
    }

    public void setSchool(SchoolEntity school) {
        this.school = school;
    }

    public Set<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }
}
