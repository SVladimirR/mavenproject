package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger("logger");
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add("Bob");
        orderBoard.add("Ted");
        orderBoard.add("Ivan");
        orderBoard.add("Stas");

        orderBoard.draw();

        orderBoard.deliver();

        orderBoard.deliver(3);

        orderBoard.draw();



    }
}