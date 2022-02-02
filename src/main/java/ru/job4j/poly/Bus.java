package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public double refuel(int count) {
        double price = 60.82;
        return count * price;
    }

    @Override
    public void move() {
        System.out.println("Автобус движется по маршруту 77");
    }
}
