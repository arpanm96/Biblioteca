package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
        return new ArrayList<>(Arrays.asList(new Book("The Hobbit"),new Book("The Lord Of The Rings")));
    }

    @Override
    public String toString() {
        return "" + bookList;
    }
}
