package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/*
A class for a library containing books
*/

public class Library {
    private Collection<Book> bookList;
    private Collection<Book> booksToBeReturnedList;

    public Library(Collection<Book> bookList) {
        booksToBeReturnedList = new ArrayList<>();
        this.bookList = bookList;
    }

    public Library() {
        bookList = new BookRepository().generateDefaultBookList();
        this.booksToBeReturnedList = new ArrayList<>();
    }

    public Collection<String> getLibraryBookDetails() {
        return this.bookList.stream().
                map(book -> (book.toString())).
                collect(Collectors.toList());
    }

    public boolean checkoutBook(Book bookToBeCheckedOut) {
        for (Book book : bookList) {
            if (book.equals(bookToBeCheckedOut)) {
                booksToBeReturnedList.add(book);
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(Book returnBook) {
        if (booksToBeReturnedList != null && this.containsBook(returnBook)) {
            bookList.add(returnBook);
            booksToBeReturnedList.remove(returnBook);
            return true;
        }
        return false;
    }

    private boolean containsBook(Book returnBook) {
        for (Book book : booksToBeReturnedList) {
            if (book.equals(returnBook)) {
                return true;
            }
        }
        return false;
    }
}
