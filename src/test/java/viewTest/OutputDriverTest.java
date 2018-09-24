package viewTest;

import controller.LibraryManagementSystem;
import model.library.LibraryItemRepository;
import model.library.ItemType;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.library.Library;
import view.InputDriver;
import view.OutputDriver;


class OutputDriverTest {

    InputDriver inputMockDriver;
    OutputDriver outputDriver;
    Library library;
    LibraryManagementSystem libraryManagementSystem;
    UserAction userAction;
    @BeforeEach
     void initEach() {
        outputDriver = new OutputDriver();
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());;
        library = new Library( new LibraryItemRepository().generateDefaultItemList());
        libraryManagementSystem = new LibraryManagementSystem(inputMockDriver, outputDriver, library, userAction);
    }

    @Disabled
    @DisplayName("should display the list of books correctly")
    @Test
    void shouldDisplayBookListCorrectly() {
        outputDriver.printItemList(library.getLibraryItemDetails(ItemType.BOOK), ItemType.BOOK.getItemHeaders());
    }

    @Disabled
    @DisplayName("should display the list of books correctly")
    @Test
    void shouldDisplayMenuCorrectly() {
        outputDriver.printMainMenu();
    }
}

