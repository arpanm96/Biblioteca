package controllerTest.actionTest;

import controller.Action;
import controller.MainMenu;
import model.library.Book;
import model.library.LibraryItemRepository;
import model.library.ItemType;
import model.library.Library;
import model.user.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ActionTest {

    UserAccount userAccount;
    Book theHobbit;
    Book theLordOfTheRings;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    Action action;
    @BeforeEach
    void initEach() {
        userAccount = new UserAccount();;
        action = mock(Action.class);
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @Disabled
    @DisplayName("check if act is being called for menu list")
    @Test
    void checkActBeingCalledForListMenu() {
        MainMenu.LIST_BOOKS.perform(library, inputDriver, outputDriver, userAccount);
        verify(action).act(library, inputDriver, outputDriver, userAccount);
    }
}
