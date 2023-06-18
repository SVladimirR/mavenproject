package hw17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMathLibraryTest {

    @Test
    @DisplayName("sym")
    void add() {
        assertEquals(4, new SimpleMathLibrary().add(2, 2));
    }

    @Test
    @DisplayName("sub")
    void minus() {
        assertEquals(0, new SimpleMathLibrary().minus(2, 2));
    }
}