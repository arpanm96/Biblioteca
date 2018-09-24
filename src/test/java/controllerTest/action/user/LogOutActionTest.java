package controllerTest.action.user;

import common.Message;
import controller.MainMenu;
import model.library.Library;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.*;

class LogOutActionTest {

    Library library;
    UserAction userAction;

    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
    }

    @DisplayName("should not log out")
    @Test
    void shouldNotLogOut() {
        MainMenu.LOG_OUT.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.LOG_OUT_UNSUCCESSFUL);
    }

    @DisplayName("should log out a logged in user")
    @Test
    void shouldLogOut() {
        when(inputDriver.getUserInput()).thenReturn("123-4567").thenReturn("Arpan");
        MainMenu.LOG_IN.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver,times(2)).getUserInput();
        verify(outputDriver).print(Message.LOG_IN_SUCCESSFUL);

        MainMenu.LOG_OUT.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.LOG_OUT_SUCCESSFUL);
    }
}
