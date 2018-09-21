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
        this.author = "-";
        this.yearPublished = 0;
    }

    @Override
    public String toString() {
        return title + "," + author + "," + yearPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.trim().equalsIgnoreCase(book.title.trim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearPublished);
    }
}
