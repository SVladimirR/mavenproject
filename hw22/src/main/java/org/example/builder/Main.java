package org.example.builder;

public class Main {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();
        CarBuilder sedanCarBuilder = new SedanCarBuilder();

        Car sedanCar = director.constructCar(sedanCarBuilder);
        sedanCar.display();
    }
}
