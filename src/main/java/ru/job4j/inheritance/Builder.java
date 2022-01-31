package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String specialisation;

    public Builder(String name, String surname, String education, String birthday, String industry, String specialisation) {
        super(name, surname, education, birthday, industry);
        this.specialisation = specialisation;
    }

    public void buildHouse(int hours) {

    }
}
