import model.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookRepositoryTest {
    BookRepository bookRepository;

    @BeforeEach
    void initEach() {
        bookRepository = new BookRepository();
    }

    @Disabled
    @DisplayName("should return default generated list correctly")
    @Test
    void shouldReturnTrueForDefaultGenerateList() {
        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList("The Hobbit,Tolkien,1937", "The Lord Of The Rings,Tolkien,1954"));
        assertEquals(bookRepository.generateDefaultBookList(), expectedList);
    }
}

