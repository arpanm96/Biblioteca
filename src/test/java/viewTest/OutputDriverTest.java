package viewTest;

import controller.LibraryManagementSystem;
import model.library.LibraryItemRepository;
import model.library.ItemType;
import model.user.User;
import model.user.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.library.Book;
import model.library.Library;
import view.InputDriver;
import view.OutputDriver;

import java.util.*;

import static org.mockito.Mockito.*;


class OutputDriverTest {

    InputDriver inputMockDriver;
    OutputDriver outputDriver;
    Library library;
    Collection<Book> booksList;
    LibraryManagementSystem libraryManagementSystem;
    UserAccount userAccount;
    @BeforeEach
     void initEach() {
        outputDriver = new OutputDriver();
        Book booksMock1 = mock(Book.class);
        Book booksMock2 = mock(Book.class);
        userAccount = new UserAccount();;
        booksList = new ArrayList<>(Arrays.asList(booksMock1, booksMock2));
        library = new Library( new LibraryItemRepository().generateDefaultItemList());
        libraryManagementSystem = new LibraryManagementSystem(inputMockDriver, outputDriver, library, userAccount);
    }

    @Disabled
    @DisplayName("should display the list of books correctly")
    @Test
    void shouldDisplayBookListCorrectly() {
        outputDriver.printBookList(library.getLibraryItemDetails(ItemType.BOOK));
    }

    @Disabled
    @DisplayName("should display the list of books correctly")
    @Test
    void shouldDisplayMenuCorrectly() {
        outputDriver.printMainMenu();
    }
}

