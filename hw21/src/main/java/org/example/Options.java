package org.example;

public enum Options {

   Stone("Stone",  0),
    Scissors("Scissors",  1),
    Paper(" Paper",  2);


    private final String name;

    private final int cost;

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    Options(String name, int cost) {
        this.name = name;
            this.cost = cost;
    }
}
