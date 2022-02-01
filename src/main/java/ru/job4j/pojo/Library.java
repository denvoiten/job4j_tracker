package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book fantasyBook = new Book("Hobbit", 476);
        Book adventureBook = new Book("The Count of Monte Cristo", 1932);
        Book codeBook = new Book("Clean Code", 700);
        Book javaBook = new Book("Core Java", 864);
        Book[] books = new Book[4];
        books[0] = fantasyBook;
        books[1] = adventureBook;
        books[2] = codeBook;
        books[3] = javaBook;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPages() + " pages.");
        }
        books[0] = books[3];
        books[3] = fantasyBook;
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPages() + " pages.");
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals("Clean Code")) {
                System.out.println(books[index].getName() + " - " + books[index].getPages() + " pages.");
            }
        }
    }
}
