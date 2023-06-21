package org.example;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodHw18 {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    public double averageOfAllNumbers(List<Integer> numbers) {
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Среднее значение: " + average);
        return average;
    }



    public List<Pair> stringToUpperCase(List<String> strings) {

        List<Pair> pairs = strings.stream()
                .map(s -> new Pair(s, s.toUpperCase()))
                .collect(Collectors.toList());


        pairs.forEach(pair -> System.out.println(pair.getlCase() + ", " + pair.getuCase()));
        return pairs;
    }
    public List<String> stringToLower(List<String> strings){

        strings.stream()
                .filter(s -> s.length() == 4 && s.equals(s.toLowerCase()))
                .forEach(System.out::println);
        return strings;
    }

}
