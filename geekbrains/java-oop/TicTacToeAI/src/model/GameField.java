package model;

import validation.InputValidator;
import validation.NaturalNumberValidator;

import java.util.Scanner;

public class GameField {
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private GameSymbol DOT_EMPTY = GameSymbol.EMPTY;
    private int rows;
    private int columns;
    private GameSymbol[][] field;
    private int requiredDots;
    private Scanner scanner;
    private InputValidator inputValidator;

    public GameField(Scanner scanner) {
        this.scanner = scanner;
    }

    public void initField() {
        inputValidator = new NaturalNumberValidator(scanner);
        System.out.print("Enter number of rows: ");
        rows = inputValidator.validateNumber();
        System.out.print("Enter number of columns: ");
        columns = inputValidator.validateNumber();

        do {
            System.out.print("Enter required number of moves to win: ");
            requiredDots = inputValidator.validateNumber();
            if (requiredDots > Math.min(rows, columns)) {
                System.out.println("Required number of moves to win should be less than or equal to smallest of number of rows and columns. Please try again.");
            }
        } while (requiredDots > Math.min(rows, columns));

        field = new GameSymbol[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    public void printField() {
        System.out.print("    ");

        for (int i = 1; i <= columns; i++) {
            System.out.printf("%3d ", i);
        }
        System.out.println();
        System.out.print("    ");
        System.out.print("┌───");
        for (int i = 1; i < columns; i++) {
            System.out.print("┬───");
        }
        System.out.println("┐");
        for (int i = 0; i < rows; i++) {
            System.out.printf("%3d │", (i + 1));
            for (int j = 0; j < columns; j++) {
                if (field[i][j] == GameSymbol.X) {
                    System.out.print(" " + ANSI_BLUE + field[i][j] + ANSI_RESET + " ");
                } else if (field[i][j] == GameSymbol.O) {
                    System.out.print(" " + ANSI_RED + field[i][j] + ANSI_RESET + " ");
                } else {
                    System.out.print(" " + field[i][j] + " ");
                }
                if (j < columns - 1) {
                    System.out.print("│");
                }
            }
            System.out.println("│");
            if (i < rows - 1) {
                System.out.print("    ├───");
                for (int j = 1; j < columns; j++) {
                    System.out.print("┼───");
                }
                System.out.println("┤");
            }
        }
        System.out.print("    └───");
        for (int i = 1; i < columns; i++) {
            System.out.print("┴───");
        }
        System.out.println("┘");
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public GameSymbol getCell(int x, int y) {
        return field[x][y];
    }

    public void setCell(int x, int y, GameSymbol dot) {
        field[x][y] = dot;
    }

    public boolean checkLine(int x, int y, int vx, int vy, GameSymbol c) {
        int wayX = x + (requiredDots - 1) * vx;
        int wayY = y + (requiredDots - 1) * vy;

        if (wayX >= rows || wayX < 0 || wayY >= columns || wayY < 0) {
            return false;
        }
        for (int i = 0; i < requiredDots; i++) {
            int itemX = x + i * vx;
            int itemY = y + i * vy;
            if (field[itemX][itemY] != c) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(GameSymbol c) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (field[i][j] == c) {
                    if (checkLine(i, j, 0, 1, c)) {
                        return true;
                    }
                    if (checkLine(i, j, 1, 0, c)) {
                        return true;
                    }
                    if (checkLine(i, j, 1, 1, c)) {
                        return true;
                    }
                    if (checkLine(i, j, -1, 1, c)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < columns;
    }

    public boolean isCellEmpty(int x, int y) {
        return field[x][y] == GameSymbol.EMPTY;
    }
}
