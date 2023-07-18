package validation;

import java.util.Scanner;

public class SymbolValidator implements GameSymbolValidator {
    private static final String SYMBOL_REGEX = "^[XO]$";
    private Scanner scanner;

    public SymbolValidator(Scanner scanner) {
        this.scanner = scanner;
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
