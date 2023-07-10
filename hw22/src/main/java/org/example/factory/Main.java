package org.example.factory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory factory = new FurnitureFactory();

        Furniture chair = factory.createFurniture("chair");
        chair.assemble();

        Furniture table = factory.createFurniture("table");
        table.assemble();
    }
}