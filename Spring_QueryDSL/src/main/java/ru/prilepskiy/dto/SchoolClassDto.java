package ru.prilepskiy.dto;

public class SchoolClassDto extends BaseDto {

    /**
     * Номер.
     */
    private Integer grade;

    /**
     * Буква.
     */
    private String character;

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
}
