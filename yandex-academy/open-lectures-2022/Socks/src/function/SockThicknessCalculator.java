package function;

import exceptions.FileReadingException;
import exceptions.InvalidFileDataException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SockThicknessCalculator implements SockThicknessCalculatorInterface {
    private int l;
    private int n;
    private int m;
    private String filePath;
    private List<Integer> pointsOfInterest;

    public SockThicknessCalculator(int l, int n, int m, String filePath, List<Integer> pointsOfInterest) {
        this.l = l;
        this.n = n;
        this.m = m;
        this.filePath = filePath;
        this.pointsOfInterest = pointsOfInterest;
    }

    private List<String> readFileLines() throws FileReadingException {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new FileReadingException("Error reading file: " + filePath, e);
        }
    }

    public void validateFileData() throws InvalidFileDataException {
        List<String> lines = readFileLines();

        int lineNumber = 0;

        for (String line : lines) {
            lineNumber++;
            String[] parts = line.split("\\s+");
            if (parts.length != 2 || !isInteger(parts[0]) || !isInteger(parts[1])) {
                throw new InvalidFileDataException("Invalid data format in " + filePath + " at line: " + lineNumber);
            }
        }
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public List<Integer> calculateThickness() throws FileReadingException {
        List<String> lines = readFileLines();

        List<Integer> balance = new ArrayList<>(l + 1);
        for (int i = 0; i <= l; i++) {
            balance.add(0);
        }

        for (int i = 0; i < n; i++) {
            String[] parts = lines.get(i).split("\\s+");
            int left = Integer.parseInt(parts[0]);
            int right = Integer.parseInt(parts[1]);
            balance.set(left - 1, balance.get(left - 1) + 1);
            balance.set(right, balance.get(right) - 1);
        }

        int currentThickness = 0;
        List<Integer> thickness = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            currentThickness += balance.get(i);
            thickness.add(currentThickness);
        }
        return thickness;
    }

    @Override
    public void printThickness(List<Integer> thickness) {
        for (int i = 0; i < m; i++) {
            int query = pointsOfInterest.get(i);
            System.out.println("Thickness of sock coating at point " + query + ": " + thickness.get(query - 1));
        }
    }
}
