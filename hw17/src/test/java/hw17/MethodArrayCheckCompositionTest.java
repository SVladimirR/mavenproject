package hw17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodArrayCheckCompositionTest {

    @Test
    void checkArray() {
        assertEquals(false, new MethodArrayCheckComposition().checkArray(new int[]{1, 1}));
    }

    @Test
    void checkArray_1() {
        assertEquals(false, new MethodArrayCheckComposition().checkArray(new int[]{4, 4, 4}));
    }

    @Test
    void checkArray_2() {
        assertEquals(true, new MethodArrayCheckComposition().checkArray(new int[]{1, 1, 4, 4}));
    }
    @Test
    void checkArray_3() {
        assertEquals(false, new MethodArrayCheckComposition().checkArray(new int[]{3, 5, 2, 6}));
    }
}