package ru.prilepskiy.groupby.molel;

import java.util.Objects;

public class Student {

    private String name;
    private Speciality speciality;
    private int year;
    private Boolean active;

    public Student(String name, Speciality speciality, int year, Boolean active) {
        this.name = name;
        this.speciality = speciality;
        this.year = year;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year &&
            Objects.equals(name, student.name) &&
            speciality == student.speciality &&
            Objects.equals(active, student.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speciality, year, active);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", speciality=").append(speciality);
        sb.append(", year=").append(year);
        sb.append(", active=").append(active);
        sb.append('}');
        return sb.toString();
    }
}
