import controller.LibraryManagementSystem;
import model.library.LibraryItemRepository;
import model.library.Library;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import view.InputDriver;
import view.OutputDriver;

/*
A class to drive the whole Biblioteca application together
*/

public class Biblioteca {
    public static void main(String[] args) {
        InputDriver inputDriver = new InputDriver();
        OutputDriver outputDriver = new OutputDriver();
        Library library = new Library(new LibraryItemRepository().generateDefaultItemList());
        UserAction userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(inputDriver,
                                            outputDriver, library, userAction);
        libraryManagementSystem.start();
        libraryManagementSystem.operateMainMenu();
    }
}
