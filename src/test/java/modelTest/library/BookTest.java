package modelTest.library;

import model.library.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class BookTest {

    Book booksMock1;
    Book booksMock2;
    Book theHobbit;
    Book theLordOfTheRings;

    @BeforeEach
    void initEach() {
        booksMock1 = mock(Book.class);
        booksMock2 = mock(Book.class);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @DisplayName("should print the hobbit book")
    @Test
    void shouldPrintTheHobbit() {
        assertEquals("The Hobbit,Tolkien,1937",theHobbit.toString());
    }

    @DisplayName("should print the lord of the rings")
    @Test
    void shouldPrintTheLordOfTheRings() {
        assertEquals("The Lord Of The Rings,Tolkien,1954",theLordOfTheRings.toString());
    }

    @DisplayName("should return true if two books are same")
    @Test
    void shouldReturnTrueIfTwoBooksAreSame() {
        assertEquals(new Book("The Lord Of The Rings","Tolkien",1954),theLordOfTheRings);
    }
}


