package model.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
A class containing the initial books in the library
*/

public class LibraryItemRepository {
    Collection<Item> bookList;

    public LibraryItemRepository() {
        this.bookList = generateDefaultItemList();
    }

    public Collection<Item> generateDefaultItemList() {
        return new ArrayList<>(Arrays.asList(new Book("The Hobbit", "Tolkien", 1937),
                new Book("The Lord Of The Rings", "Tolkien", 1954),
                new Movie("Shawshank Redemption", "Frank Darabont", 10, 1994),
                new Movie("Se7en", "David Fincher", 9, 1995)));
    }
}
