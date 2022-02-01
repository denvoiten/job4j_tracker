package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Voitenko Denis Andreevich");
        student.setGroup(7);
        student.setDateOfEntry("01.01.2022");

        System.out.println("Student: " + student.getFullName()
                + ". Group: " + student.getGroup()
                + ". Date of entry: " + student.getDateOfEntry());
    }
}
