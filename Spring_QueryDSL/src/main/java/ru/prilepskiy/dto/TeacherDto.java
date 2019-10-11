package ru.prilepskiy.dto;

import java.util.Set;

public class TeacherDto extends BaseDto {

    /**
     * Имя.
     */
    private String firstName;

    /**
     * Отчество.
     */
    private String middleName;

    /**
     * Фамилия.
     */
    private String lastName;

    /**
     * Школа.
     */
    private String schoolNumber;

    /**
     * Классы.
     */
    private Set<SchoolClassShortDto> classes;

    /**
     * Кол-во учеников.
     */
    private Integer numberStudents;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Set<SchoolClassShortDto> getClasses() {
        return classes;
    }

    public void setClasses(Set<SchoolClassShortDto> classes) {
        this.classes = classes;
    }

    public Integer getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(Integer numberStudents) {
        this.numberStudents = numberStudents;
    }
}
