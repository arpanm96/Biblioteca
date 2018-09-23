import controller.LibraryManagementSystem;
import model.library.LibraryItemRepository;
import model.library.Library;
import model.user.UserAccount;
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
        UserAccount userAccount = new UserAccount();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library, userAccount);
        libraryManagementSystem.start();
        libraryManagementSystem.performOnMenuChoice();
    }
}
