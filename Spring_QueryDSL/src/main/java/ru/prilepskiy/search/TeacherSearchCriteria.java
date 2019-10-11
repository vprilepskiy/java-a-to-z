package ru.prilepskiy.search;

import org.springframework.lang.Nullable;

public class TeacherSearchCriteria {

    /**
     * Идентификатор школы.
     */
    @Nullable
    private Integer schoolId;

    /**
     * Идентификатор класса.
     */
    @Nullable
    private Integer classId;

    /**
     * Имя учителя.
     */
    @Nullable
    private String teacherFirstName;

    /**
     * Отчество учителя.
     */
    @Nullable
    private String teacherMiddleName;

    /**
     * Фамилия учителя.
     */
    @Nullable
    private String teacherLastName;

    /**
     * Имя ученика.
     */
    @Nullable
    private String studentFirstName;

    /**
     * Отчество ученика.
     */
    @Nullable
    private String studentMiddleName;

    /**
     * Фамилия ученика.
     */
    @Nullable
    private String studentLastName;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherMiddleName() {
        return teacherMiddleName;
    }

    public void setTeacherMiddleName(String teacherMiddleName) {
        this.teacherMiddleName = teacherMiddleName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentMiddleName() {
        return studentMiddleName;
    }

    public void setStudentMiddleName(String studentMiddleName) {
        this.studentMiddleName = studentMiddleName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
}
