package ru.job4j.stream;

import java.util.stream.Stream;

public enum Suit {
    DIAMONDS, HEARTS, SPADES, CLUBS
}

enum Value {
    V_2, V_3, V_4, V_5, V_6, V_7, V_8, V_9, V_T, V_J, V_Q, V_K, V_A
}

class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);

    }
}
