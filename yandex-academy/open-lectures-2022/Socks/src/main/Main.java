package main;

import function.SockThicknessCalculator;
import function.SockThicknessCalculatorInterface;
import validation.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String filePath = "socks_ends_data.txt";
        SockFileValidatorInterface fileValidator = new SockFileValidator(filePath);
        if (!fileValidator.isFileValid()) {
            return;
        }

        fileValidator.notifyFileReadSuccessfully();

        InputValidator inputValidator = new TableSocksPointsValidator(scanner);

        System.out.print("Enter numbers for L, N, and M separated by whitespace: ");
        List<Integer> inputValues = inputValidator.validate();
        int l = inputValues.get(0);
        int n = inputValues.get(1);
        int m = inputValues.get(2);

        GirlsInterestPointsValidatorInterface pointValidator = new GirlsInterestPointsValidator(scanner, m);
        int[] pointsOfInterest = pointValidator.validateInterestPoints();

        SockThicknessCalculatorInterface calculator = new SockThicknessCalculator(l, n, m, filePath, pointsOfInterest);
        int[] thickness = calculator.calculateThickness();

        if (thickness != null) {
            calculator.printThickness(thickness);
        }

        scanner.close();
    }
}