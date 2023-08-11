package main;

import errorhandler.BasicErrorHandler;
import errorhandler.ErrorHandlerInterface;
import function.SockThicknessCalculator;
import function.SockThicknessCalculatorInterface;
import validation.*;
import exceptions.InvalidFileDataException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ErrorHandlerInterface errorHandler = new BasicErrorHandler();

        String filePath = "socks_ends_data.txt";
        SockFileValidatorInterface fileValidator = new SockFileValidator(filePath);
        if (!fileValidator.isFileValid()) {
            return;
        }

        SockThicknessCalculatorInterface calculator = new SockThicknessCalculator(0, 0, 0, filePath, null);

        try {
            calculator.validateFileData();
        } catch (InvalidFileDataException e) {
            errorHandler.handleException(e);
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
        List<Integer> pointsOfInterest = pointValidator.validateInterestPoints();

        calculator = new SockThicknessCalculator(l, n, m, filePath, pointsOfInterest);
        try {
            List<Integer> thickness = calculator.calculateThickness();
            calculator.printThickness(thickness);
        } catch (Exception e) {
            errorHandler.handleException(e);
        }
        scanner.close();
    }
}
