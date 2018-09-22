package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class BookRepository {
    Collection<Item> bookList;

    public BookRepository() {
        this.bookList = generateDefaultItemList();
    }

    public Collection<Item> generateDefaultItemList() {
        return new ArrayList<>(Arrays.asList(new Book("The Hobbit", "Tolkien", 1937),
                new Book("The Lord Of The Rings", "Tolkien", 1954)));
    }
}
