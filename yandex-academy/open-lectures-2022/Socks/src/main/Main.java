package main;

import errorhandler.BasicErrorHandler;
import errorhandler.ErrorHandlerInterface;
import function.SockThicknessCalculatorInterface;
import validation.*;
import exceptions.InvalidFileDataException;
import factories.SockFileValidatorFactory;
import factories.SockThicknessCalculatorFactory;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {

    private static SockFileValidatorFactory fileValidatorFactory = new SockFileValidatorFactory();
    private static SockThicknessCalculatorFactory calculatorFactory = new SockThicknessCalculatorFactory();

    public static void main(String[] args) {
        String filePath;

        if (args.length == 0 || !new File(args[0]).exists()) {
            System.out.println("Please specify the path to the sock data file: ");
            Scanner scannerForPath = new Scanner(System.in);
            filePath = scannerForPath.nextLine();
        } else {
            filePath = args[0];
        }

        ErrorHandlerInterface errorHandler = new BasicErrorHandler();
        List<String> fileLines = readAllLines(filePath);

        try (Scanner scanner = new Scanner(System.in)) {
            SockFileValidatorInterface fileValidator = fileValidatorFactory.create(filePath);
            if (!fileValidator.isFileValid()) {
                return;
            }

            SockThicknessCalculatorInterface calculator = calculatorFactory.create(0, 0, 0, fileLines, null);

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

            calculator = calculatorFactory.create(l, n, m, fileLines, pointsOfInterest);
            try {
                List<Integer> thickness = calculator.calculateThickness();
                calculator.printThickness(thickness);
            } catch (Exception e) {
                errorHandler.handleException(e);
            }
        }
    }

    private static List<String> readAllLines(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }
}
