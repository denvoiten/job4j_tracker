package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String industry;

    public Engineer(String name, String surname, String education, String birthday, String industry) {
        super(name, surname, education, birthday);
        this.industry = industry;
    }

    public void research() {

    }
}
