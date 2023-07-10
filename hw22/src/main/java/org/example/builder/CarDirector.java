package org.example.builder;

public class CarDirector {
    public Car constructCar(CarBuilder builder) {
        builder.buildEngine();
        builder.buildTires();
        builder.buildBody();
        return builder.getCar();
    }
}
