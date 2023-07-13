package game;

import model.GameField;
import model.GameSymbol;
import player.Player;

import java.util.Scanner;

public class Game {
    private GameField field;
    private Player humanPlayer;
    private Player aiPlayer;
    private Scanner scanner;
    private int totalMoves = 0;

    public Game(Player humanPlayer, Player aiPlayer, Scanner scanner) {
        this.humanPlayer = humanPlayer;
        this.aiPlayer = aiPlayer;
        this.scanner = scanner;
        this.field = new GameField(scanner);
    }

    public void start() {
        System.out.println("Welcome to game!");
        System.out.print("Choose your symbol (X / O): ");
        GameSymbol humanSymbol = "X".equalsIgnoreCase(scanner.nextLine()) ? GameSymbol.X : GameSymbol.O;
        GameSymbol aiSymbol = (humanSymbol == GameSymbol.X) ? GameSymbol.O : GameSymbol.X;

        humanPlayer.setSymbol(humanSymbol);
        aiPlayer.setSymbol(aiSymbol);

        while (true) {
            boolean gameOver = playRound();
            if (gameOver) {
                System.out.println("Game Over.");
                System.out.print("Play again? Yes / No: ");
                String response = scanner.nextLine();
                if (!"Yes".equalsIgnoreCase(response)) {
                    break;
                }
            }
        }
    }

    private boolean playRound() {
        field.initField();
        totalMoves = 0;

        if (aiPlayer.getSymbol() == GameSymbol.X) {
            aiPlayer.makeMove(field);
            totalMoves++;
        }

        while (true) {
            field.printField();
            if (!humanPlayer.makeMove(field)) {
                return true;
            }
            totalMoves++;
            field.printField();
            if (checkEndGame(humanPlayer.getSymbol()) || isFieldFull()) {
                return true;
            }

            if (totalMoves < field.getRows() * field.getColumns()) {
                if (!aiPlayer.makeMove(field)) {
                    return true;
                }
                totalMoves++;
                field.printField();
                if (checkEndGame(aiPlayer.getSymbol()) || isFieldFull()) {
                    return true;
                }
            }
        }
    }

    private boolean isFieldFull() {
        if (totalMoves >= field.getRows() * field.getColumns()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    public boolean checkEndGame(GameSymbol dot) {
        if (field.checkWin(dot)) {
            if (dot == GameSymbol.X) {
                System.out.println("AI wins!");
            } else {
                System.out.println("Human wins!");
            }
            return true;
        }
        return false;
    }
}