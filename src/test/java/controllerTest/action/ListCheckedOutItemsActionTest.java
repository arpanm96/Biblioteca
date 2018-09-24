package controllerTest.action;

import common.Message;
import controller.LibraryManagementSystem;
import controller.MainMenu;
import model.library.Book;
import model.library.ItemType;
import model.library.Library;
import model.library.LibraryItemRepository;
import model.user.User;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ListCheckedOutItemsActionTest {

    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    UserAction userAction;
    User user;

    @BeforeEach
    void initEach() {
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        user = new User("123-4567", "Arpan");

        //userAction = mock(UserAction.class);
        //user = mock(User.class);
        userAction.logIn(user);
    }

    @DisplayName("should print correct checked out item list")
    @Test
    void shouldPrintCorrectCheckedOutItemList() {
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);

        //assertEquals(user.);

        //when(userAction.getCurrentlyLoggedInUser()).thenReturn(user);
        //assertFalse(library.returnItem(theHobbit, userAction));
    }

}