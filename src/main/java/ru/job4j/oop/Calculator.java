package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int value) {
        return x + value;
    }

    public int multiply(int value) {
        return x * value;
    }

    public static int minus(int value) {
        return x - value;
    }

    public int divide(int value) {
        return value / x;
    }

    public int sumAllOperation(int value) {
        return sum(value) + multiply(value)
                + divide(value) + minus(value);
    }

    public static void main(String[] args) {
        int rslSum = sum(10);
        System.out.println(rslSum);
        Calculator calculator = new Calculator();
        int rslMulti = calculator.multiply(5);
        System.out.println(rslMulti);
        int rslMinus = minus(1);
        System.out.println(rslMinus);
        Calculator divider = new Calculator();
        System.out.println(divider.divide(35));
    }
}
