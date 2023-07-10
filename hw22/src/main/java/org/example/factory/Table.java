package org.example.factory;

public class Table extends Furniture {
    @Override
    public void assemble() {
        System.out.println("Assembling a table");
    }
}
