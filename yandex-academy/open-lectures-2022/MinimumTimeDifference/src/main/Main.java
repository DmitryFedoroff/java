package main;

import validation.NumberValidator;
import validation.TimeValidator;
import validation.TrainCountValidator;
import validation.TimePointsValidator;
import function.TrainTimeDifferenceFinder;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        NumberValidator trainCountValidator = new TrainCountValidator(scanner);
        System.out.print("Enter number of trains: ");
        int numberOfTrains = trainCountValidator.validateNumber();

        TimeValidator timePointsValidator = new TimePointsValidator(scanner, numberOfTrains);
        System.out.print("Enter 24-hour clock time points (HH:MM): ");
        String[] timePoints = timePointsValidator.validateTimePoints();

        TrainTimeDifferenceFinder finder = new TrainTimeDifferenceFinder();
        int result = finder.findMinDist(numberOfTrains, timePoints);

        System.out.println("Minimum minutes difference between arrival of two trains: " + result);

        scanner.close();
    }
}
