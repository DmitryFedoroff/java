package game;

import model.GameField;
import model.GameSymbol;
import player.Player;
import player.HumanPlayer;
import player.AIPlayer;

import java.util.Scanner;

public class Game {
    private GameField field;
    private Player humanPlayer;
    private Player aiPlayer;
    private int currentTurn = 1;
    private Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.field = new GameField(scanner);
        this.humanPlayer = new HumanPlayer();
        this.aiPlayer = new AIPlayer();
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
        while (true) {
            humanPlayer.makeMove(field);
            field.printField();
            if (checkEndGame(GameSymbol.X)) {
                break;
            }

            aiPlayer.makeMove(field);
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
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (field.getCell(i, j) == GameSymbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}

