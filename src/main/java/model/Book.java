package model;


import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int yearPublished;


    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Book(String title) {
        this.title = title;
        this.author= "-";
        this.yearPublished = 0;
    }

    @Override
    public String toString() {
        return String.format("%-25s %8s %8s", title, author, yearPublished);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title.trim(), book.title.trim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearPublished);
    }
}
