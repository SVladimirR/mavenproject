package org.example.builder;

public interface CarBuilder {
    void buildEngine();
    void buildTires();
    void buildBody();
    Car getCar();
}
