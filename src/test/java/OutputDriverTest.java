import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.OutputDriver;


class OutputDriverTest {

    OutputDriver outputMockDriver;
    Library library;
    @BeforeEach
     void initEach() {
        outputMockDriver = Mockito.mock(OutputDriver.class);
        Library library = new Library(outputMockDriver);
    }
    @DisplayName("Should expect call to print the message")
    @Test
    void shouldPrintWelcomeToBiblioteca() {
        Mockito.verify(outputMockDriver).printWelcomeMessage("Welcome To Biblioteca");
    }
}
