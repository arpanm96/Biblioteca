package model;

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
        bookList = new BookRepository().generateDefaultBookList();
    }

    public Collection<String> getLibraryBookDetails() {
        return this.bookList.stream().
                map(book -> (book.toString())).
                collect(Collectors.toList());
    }
}
