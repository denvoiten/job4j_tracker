package ru.job4j.inheritance;

public class Doctor extends Profession {

    private boolean licensed;

    public Doctor(String name, String surname, String education, String birthday, boolean licensed) {
        super(name, surname, education, birthday);
        this.licensed = licensed;
    }

    public boolean getLicensed() {
        return licensed;
    }

    public Diagnosis heal(Patient patient) {
        return new Diagnosis();
    }
}
