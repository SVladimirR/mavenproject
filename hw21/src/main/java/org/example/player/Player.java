package org.example.player;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class Player {

    private String name;
    private Integer numberOfGames = 0;
    private Integer numberOfWinGames = 0;
    private Integer numberOfLossGames = 0;


    public Player(String name) {
        this.name = name;
    }

    public void incrementNumberOfGames() {
        numberOfGames++;
    }

    public void incrementNumberOfWinGames() {
        numberOfWinGames++;
    }

    public void incrementNumberOfLossGames() {
        numberOfLossGames++;
    }

    public String getPlayerResult() {
        return "Player " + name + " win  " + numberOfWinGames + " loss " + numberOfLossGames +
                " games from " + numberOfGames;
    }


}


