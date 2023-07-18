package player;

import model.GameField;
import model.GameSymbol;
import validation.TwoNaturalNumbersValidator;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private GameSymbol symbol;
    private TwoNaturalNumbersValidator inputValidator;

    public void setSymbol(GameSymbol symbol) {
        this.symbol = symbol;
    }

    public GameSymbol getSymbol() {
        return symbol;
    }

    @Override
    public boolean makeMove(GameField field) {
        int x, y;
        inputValidator = new TwoNaturalNumbersValidator(new Scanner(System.in));

        do {
            System.out.print("Enter coordinates of your turn x and y, separated by space: ");
            int[] coordinates = inputValidator.validateNumbers();
            x = coordinates[0] - 1;
            y = coordinates[1] - 1;
        } while (!field.isCellValid(x, y) || !field.isCellEmpty(x, y));

        field.setCell(x, y, symbol);
        return true;
    }
}
