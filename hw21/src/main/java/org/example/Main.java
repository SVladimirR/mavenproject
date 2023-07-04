package org.example;

import org.example.computer.Computer;
import org.example.player.Player;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter number of games [more then 0]: ");
        int gameCount = sc.nextInt();
        sc.nextLine();

        Player pl = new Player(name);
        GameResult gr = new GameResult();
        Computer comp = new Computer();


        String nextGame;
        int game = 1;

        do {
            System.out.println("---------------------->>>>>");
            System.out.println("Game " + game + " from " + gameCount);


            System.out.println("Make your choice: 0 - " + Options.Stone + ", 1 - " + Options.Scissors + ", 2 - " + Options.Paper);
            Integer varPlayer = sc.nextInt();
            Integer varComputer = comp.generateRandomNumber();
            System.out.println("Computer chose: " + Options.values()[varComputer]);
            char resGame = gr.gameRes(varComputer, varPlayer);

            pl.incrementNumberOfGames();
            if (resGame == ('+')) {
                pl.incrementNumberOfWinGames();
                System.out.println("WIN " + pl.getName());
            } else if (resGame == ('-')) {
                pl.incrementNumberOfLossGames();
                System.out.println("WIN Computer");
            } else {
                System.out.println("Draw");
            }

            if (game++ != gameCount) {
                System.out.println("Next game ... [Y/N]");
                System.out.println();
                sc.nextLine();                      // без этой строки  не дает ввести.
                nextGame = sc.nextLine();

            } else {
                break;
            }

        } while (nextGame.equalsIgnoreCase("y"));

        System.out.println(pl.getPlayerResult());

    }
}