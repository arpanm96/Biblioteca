package controllerTest.actionTest.user;

import common.Message;
import controller.MainMenu;
import model.library.Library;
import model.user.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.*;

class LogInActionTest {

    UserAccount userAccount;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAccount = new UserAccount();
    }

    @DisplayName("should login user")
    @Test
    void logInSuccessfully() {
        when(inputDriver.getUserInput()).thenReturn("123-4567").thenReturn("Arpan");
        MainMenu.LOG_IN.perform(library, inputDriver, outputDriver, userAccount);
        verify(inputDriver,times(2)).getUserInput();
        verify(outputDriver).print(Message.LOG_IN_SUCCESSFUL);
    }

    @DisplayName("should not login user")
    @Test
    void logInUnSuccessfully() {
        when(inputDriver.getUserInput()).thenReturn("000-4567").thenReturn("Arpan");
        MainMenu.LOG_IN.perform(library, inputDriver, outputDriver, userAccount);
        verify(inputDriver,times(2)).getUserInput();
        verify(outputDriver).print(Message.LOG_IN_UNSUCCESSFUL);
    }
}