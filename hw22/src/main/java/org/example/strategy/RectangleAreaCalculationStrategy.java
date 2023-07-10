package org.example.strategy;

public class RectangleAreaCalculationStrategy implements AreaCalculationStrategy {
    @Override
    public double calculateArea(double[] dimensions) {
        double length = dimensions[0];
        double width = dimensions[1];
        return length * width;
    }
}
