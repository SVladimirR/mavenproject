package org.example.strategy;

public class Shape {
    private AreaCalculationStrategy calculationStrategy;

    public void setCalculationStrategy(AreaCalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    public double calculateArea(double[] dimensions) {
        return calculationStrategy.calculateArea(dimensions);
    }
}
