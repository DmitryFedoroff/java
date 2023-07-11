package game;

import model.GameField;
import model.GameSymbol;
import player.Player;

import java.util.Scanner;

public class Game {
    private GameField field;
    private Player humanPlayer;
    private Player aiPlayer;
    private int currentTurn = 1;
    private Scanner scanner;
    private int totalMoves = 0;

    public Game(Player humanPlayer, Player aiPlayer, Scanner scanner) {
        this.humanPlayer = humanPlayer;
        this.aiPlayer = aiPlayer;
        this.scanner = scanner;
        this.field = new GameField(scanner);
    }

    public void start() {
        System.out.println("Welcome to game! Let's get started.");
        while (true) {
            playRound();
            System.out.print("Play again? Yes / No: ");
            String response = scanner.nextLine();
            if (!"Yes".equalsIgnoreCase(response)) {
                break;
            }
        }
    }

    private void playRound() {
        field.initField();
        field.printField();
        totalMoves = 0;

        while (true) {
            humanPlayer.makeMove(field);
            totalMoves++;
            field.printField();
            if (checkEndGame(GameSymbol.X)) {
                break;
            }

            aiPlayer.makeMove(field);
            totalMoves++;
            field.printField();
            if (checkEndGame(GameSymbol.O)) {
                break;
            }
        }
    }

    public boolean checkEndGame(GameSymbol dot) {
        if (field.checkWin(dot)) {
            if (dot == GameSymbol.X) {
                System.out.println("Human wins!");
            } else {
                System.out.println("AI wins!");
            }
            return true;
        }
        if (isFieldFull()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    private boolean isFieldFull() {
        return totalMoves >= field.getRows() * field.getColumns();
    }
}
