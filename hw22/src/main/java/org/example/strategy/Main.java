package org.example.strategy;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Shape();
        rectangle.setCalculationStrategy(new RectangleAreaCalculationStrategy());
        double rectangleArea = rectangle.calculateArea(new double[]{5, 4});
        System.out.println("Rectangle area: " + rectangleArea);

        Shape triangle = new Shape();
        triangle.setCalculationStrategy(new TriangleAreaCalculationStrategy());
        double triangleArea = triangle.calculateArea(new double[]{3, 6});
        System.out.println("Triangle area: " + triangleArea);
    }
}
