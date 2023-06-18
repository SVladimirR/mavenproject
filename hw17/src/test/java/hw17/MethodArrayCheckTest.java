package hw17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodArrayCheckTest {


    @Test
    void arrayCheckingElements() {
        assertArrayEquals(new int[]{1, 7}, new MethodArrayCheck().arrayCheckingElements(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, 4));
        assertArrayEquals(new int[]{2, 3, 1, 7}, new MethodArrayCheck().arrayCheckingElements(new int[]{1, 2, 4, 4, 2, 3, 1, 7}, 4));

    }

    @Test
    void arrayCheckingElements_1() {

        assertArrayEquals(new int[]{2, 3, 1, 7}, new MethodArrayCheck().arrayCheckingElements(new int[]{1, 2, 4, 4, 2, 3, 1, 7}, 4));

    }

    @Test
    void arrayCheckingElements_2() {

        assertThrows(RuntimeException.class, () -> new MethodArrayCheck().arrayCheckingElements(new int[]{1, 2, 2, 3, 1, 7}, 4));
    }

}