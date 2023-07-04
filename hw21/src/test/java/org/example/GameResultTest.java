package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void gameRes() {

        GameResult gameResult = new GameResult();

        char result1 = gameResult.gameRes(0, 0);
        Assertions.assertEquals('=', result1);

        char result2 = gameResult.gameRes(1, 2);
        Assertions.assertEquals('-', result2);

        char result3 = gameResult.gameRes(2, 1);
        Assertions.assertEquals('+', result3);
    }

}