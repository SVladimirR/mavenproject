package org.example.builder;


public class Car {
    private String engine;
    private String tires;
    private String body;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setTires(String tires) {
        this.tires = tires;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void display() {
        System.out.println("Engine: " + engine);
        System.out.println("Tires: " + tires);
        System.out.println("Body: " + body);
    }
}
