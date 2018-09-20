package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/*
A class for a library containing books
*/

public class Library {
    private Collection<Book> bookList;

    public Library(Collection<Book> bookList) {
        this.bookList = bookList;
    }

    public Library() {
        bookList = generateDefaultBookList();
    }

    private Collection<Book> generateDefaultBookList() {
        return new ArrayList<>(Arrays.asList(new Book("The Hobbit", "Tolkien", 1954), new Book("The Lord Of The Rings", "Tolkien", 1954)));
    }

    public Collection<String> getTitlesList() {
        return this.bookList.stream().map(Book::getTitle).collect(Collectors.toList());
    }
}
