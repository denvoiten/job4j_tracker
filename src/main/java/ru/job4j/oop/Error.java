package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error err = new Error();
        Error errSec = new Error(true, 64, "Invalid ID");
        Error errThr = new Error(false, -1, "Program load");
        err.showInfo();
        System.out.println();
        errSec.showInfo();
        System.out.println();
        errThr.showInfo();
    }
}
