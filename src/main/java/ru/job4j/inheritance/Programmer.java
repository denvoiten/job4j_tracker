package ru.job4j.inheritance;

public class Programmer extends Engineer {
    public String stack;

    public Programmer(String name, String surname, String education, String birthday, String industry, String stack) {
        super(name, surname, education, birthday, industry);
        this.stack = stack;
    }

    public void solveTask(Task task) {

    }
}
