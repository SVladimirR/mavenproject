package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodHw18Test {


    @Test
    @DisplayName("Среднее значение")
    void averageOfAllNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(3, new MethodHw18().averageOfAllNumbers(numbers));
    }


    @Test
    @DisplayName("String To Upper Case")
    void stringToUpperCase() {
        List<String> strings = Arrays.asList("one", "two", "three");

        List<Pair> pairs = new ArrayList<>();
        for (String s : strings) {
            pairs.add(new Pair(s, s.toUpperCase()));
        }

        Assertions.assertEquals(3, pairs.size());

        Pair pair1 = pairs.get(0);
        Assertions.assertEquals("one", pair1.getlCase());
        Assertions.assertEquals("ONE", pair1.getuCase());

        Pair pair2 = pairs.get(1);
        Assertions.assertEquals("two", pair2.getlCase());
        Assertions.assertEquals("TWO", pair2.getuCase());
    }

    @Test
    @DisplayName("String To Lower")
    void stringToLower() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "Five");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        System.setOut(printStream);

        strings.stream()
                .filter(s -> s.length() == 4 && s.equals(s.toLowerCase()))
                .forEach(System.out::println);

        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString().trim();
        String[] lines = output.split(System.lineSeparator());

        Assertions.assertEquals(1, lines.length);
        Assertions.assertEquals("four", lines[0]);
    }

}