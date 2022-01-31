package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String specialisation;

    public Dentist(String name, String surname, String education, String birthday, boolean licensed, String specialisation) {
        super(name, surname, education, birthday, licensed);
        this.specialisation = specialisation;
    }

    public void checkup(Patient patient) {

    }
}
