package controllerTest.actionTest.book;

import controller.MainMenu;
import model.library.Book;
import model.library.ItemType;
import model.library.Library;
import model.user.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ListBookActionTest {

    Book booksMock1;
    Book booksMock2;
    Book theHobbit;
    Book theLordOfTheRings;
    Collection<Book> bookCollection;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    UserAccount userAccount;

    @BeforeEach
    void initEach() {
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        booksMock1 = mock(Book.class);
        booksMock2 = mock(Book.class);
        userAccount = new UserAccount();;
        bookCollection = new ArrayList<>(Arrays.asList(booksMock1, booksMock2));
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @DisplayName("verify perform on menu list")
    @Test
    void actOnMenuList() {
        MainMenu.LIST_BOOKS.perform(library, inputDriver, outputDriver, userAccount);
        verify(outputDriver).printBookList(bookDetails);
        verify(library,times(2)).getLibraryItemDetails(ItemType.BOOK);
    }
}
