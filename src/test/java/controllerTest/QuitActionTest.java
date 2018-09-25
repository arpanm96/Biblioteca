package controllerTest;

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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class QuitActionTest {

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    UserAction userAction;

    @BeforeEach
    void initEach() {
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
    }

    @DisplayName("should exit successfully")
    @Test
    void shouldExit() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(9);
        MainMenu.QUIT.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.EXIT_BIBLIOTECA);
    }
}