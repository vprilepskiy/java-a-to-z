package ru.prilepskiy.search;

public class TeacherSearchCriteria {

    /**
     * Идентификатор школы.
     */
    private Integer schoolId;

    /**
     * Идентификатор класса.
     */
    private Integer classId;

    /**
     * Имя учителя.
     */
    private String teacherFirstName;

    /**
     * Отчество учителя.
     */
    private String teacherMiddleName;

    /**
     * Фамилия учителя.
     */
    private String teacherLastName;

    /**
     * Имя ученика.
     */
    private String studentFirstName;

    /**
     * Отчество ученика.
     */
    private String studentMiddleName;

    /**
     * Фамилия ученика.
     */
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
