package org.example;

public class GameResult {

    public char gameRes(Integer c, Integer p) {

        char[][] array = {
                { '=', '-', '+'},
                { '+', '=', '-'},
                { '-', '+', '='}
        };
        return array[c][p];

    }
}
