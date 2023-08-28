package main;

import factories.FileValidatorFactoryInterface;
import factories.SockFileValidatorFactory;
import factories.ThicknessCalculatorFactoryInterface;
import factories.SockThicknessCalculatorFactory;
import function.SockThicknessCalculatorInterface;
import validation.InputValidator;
import validation.SockFileValidatorInterface;
import validation.TableSocksPointsValidator;
import validation.GirlsInterestPointsValidatorInterface;
import validation.GirlsInterestPointsValidator;
import errorhandler.ErrorHandlerInterface;
import errorhandler.BasicErrorHandler;
import exceptions.InvalidFileDataException;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {

    private static final int ARGUMENT_FILE_PATH_INDEX = 0;
    private static final int L_INDEX = 0;
    private static final int N_INDEX = 1;
    private static final int M_INDEX = 2;

    private final FileValidatorFactoryInterface fileValidatorFactory;
    private final ThicknessCalculatorFactoryInterface calculatorFactory;

    public Main(FileValidatorFactoryInterface fileValidatorFactory,
                ThicknessCalculatorFactoryInterface calculatorFactory) {
        this.fileValidatorFactory = fileValidatorFactory;
        this.calculatorFactory = calculatorFactory;
    }

    public void run(String[] args) {
        String filePath;

        if (args.length == 0 || !new File(args[ARGUMENT_FILE_PATH_INDEX]).exists()) {
            System.out.println("Please specify path to sock data file: ");
            Scanner scannerForPath = new Scanner(System.in);
            filePath = scannerForPath.nextLine();
        } else {
            filePath = args[ARGUMENT_FILE_PATH_INDEX];
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
            int l = inputValues.get(L_INDEX);
            int n = inputValues.get(N_INDEX);
            int m = inputValues.get(M_INDEX);

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

    public static void main(String[] args) {
        FileValidatorFactoryInterface fileValidatorFactory = new SockFileValidatorFactory();
        ThicknessCalculatorFactoryInterface calculatorFactory = new SockThicknessCalculatorFactory();

        Main application = new Main(fileValidatorFactory, calculatorFactory);
        application.run(args);
    }
}
