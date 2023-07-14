package validation;

import java.util.Scanner;

public class SymbolValidator implements InputValidator {
    private static final String SYMBOL_REGEX = "^[XO]$";
    private Scanner scanner;

    public SymbolValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int validateNumber() {
        throw new UnsupportedOperationException("Method validateNumber() is not supported in this class.");
    }

    @Override
    public int[] validateNumbers() {
        throw new UnsupportedOperationException("Method validateNumbers() is not supported in this class.");
    }

    @Override
    public String validateSymbol() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(SYMBOL_REGEX)) {
                System.out.print("Invalid input. Please enter X or O symbol: ");
            } else {
                return input;
            }
        }
    }
}
