package function;

import exceptions.InvalidFileDataException;
import java.util.ArrayList;
import java.util.List;

public class SockThicknessCalculator implements SockThicknessCalculatorInterface {
    private int l;
    private int n;
    private int m;
    private List<String> fileLines;
    private List<Integer> pointsOfInterest;

    public SockThicknessCalculator(int l, int n, int m, List<String> fileLines, List<Integer> pointsOfInterest) {
        this.l = l;
        this.n = n;
        this.m = m;
        this.fileLines = fileLines;
        this.pointsOfInterest = pointsOfInterest;
    }

    public void validateFileData() throws InvalidFileDataException {
        int lineNumber = 0;

        for (String line : fileLines) {
            lineNumber++;
            String[] parts = line.split("\\s+");
            if (parts.length != 2 || !isInteger(parts[0]) || !isInteger(parts[1])) {
                throw new InvalidFileDataException("Invalid data format at line: " + lineNumber);
            }
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public List<Integer> calculateThickness() {
        List<Integer> balance = new ArrayList<>(l + 1);
        for (int i = 0; i <= l; i++) {
            balance.add(0);
        }

        for (int i = 0; i < n; i++) {
            String[] parts = fileLines.get(i).split("\\s+");
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
