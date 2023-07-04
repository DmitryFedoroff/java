package player;

import model.GameField;
import validation.InputValidator;
import validation.TwoNaturalNumbersValidator;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private InputValidator inputValidator;

    @Override
    public void makeMove(GameField field) {
        int x, y;
        inputValidator = new TwoNaturalNumbersValidator(new Scanner(System.in));
        
        do {
            System.out.print("Enter coordinates of your turn x and y, separated by space: ");
            int[] coordinates = inputValidator.validate();
            x = coordinates[0] - 1;
            y = coordinates[1] - 1;
        } while (!field.isCellValid(x, y) || !field.isCellEmpty(x, y));
        field.setCell(x, y, 'X');
    }
}

