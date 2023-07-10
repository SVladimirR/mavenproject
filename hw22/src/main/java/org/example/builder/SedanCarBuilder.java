package org.example.builder;

public class SedanCarBuilder implements CarBuilder {
    private final Car car;

    public SedanCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("Sedan Engine");
    }

    @Override
    public void buildTires() {
        car.setTires("Sedan Tires");
    }

    @Override
    public void buildBody() {
        car.setBody("Sedan Body");
    }

    @Override
    public Car getCar() {
        return car;
    }

}
