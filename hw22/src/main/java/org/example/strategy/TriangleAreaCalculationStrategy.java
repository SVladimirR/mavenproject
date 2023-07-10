package org.example.strategy;

public class TriangleAreaCalculationStrategy implements AreaCalculationStrategy {
    @Override
    public double calculateArea(double[] dimensions) {
        double base = dimensions[0];
        double height = dimensions[1];
        return 0.5 * base * height;
    }

}
