package modelTest.library;

import model.library.ItemType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTypeTest {

    @DisplayName("should return correct book headers")
    @Test
    void shouldReturnBookHeaders() {
        assertEquals("Title,Author,Year Published",ItemType.BOOK.getItemHeaders());
    }

    @DisplayName("should return correct movie headers")
    @Test
    void shouldReturnMovieHeaders() {
        assertEquals("Name,Year,Movie Rating,Director",ItemType.MOVIE.getItemHeaders());
    }
}
