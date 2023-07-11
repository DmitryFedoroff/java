package main;

import game.Game;
import player.AIPlayer;
import player.HumanPlayer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new HumanPlayer(), new AIPlayer(), new Scanner(System.in));
        game.start();
    }
}
