package function;

import exceptions.InvalidFileDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SockThicknessCalculator implements SockThicknessCalculatorInterface {
    private static final int EXPECTED_PARTS_PER_LINE = 2;
    private static final int INITIAL_BALANCE = 0;
    private static final int BALANCE_INCREMENT = 1;
    private static final int BALANCE_DECREMENT = -1;

    private int l;
    private int n;
    private int m;
    private List<String> fileLines;
    private List<Integer> pointsOfInterest;
    private Map<Integer, String[]> parsedLinesCache = new HashMap<>();

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
            if (parts.length != EXPECTED_PARTS_PER_LINE) {
                throw new InvalidFileDataException("Invalid data format at line: " + lineNumber);
            }
            for (String part : parts) {
                if (!isInteger(part)) {
                    throw new InvalidFileDataException("Invalid data format at line: " + lineNumber);
                }
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
            balance.add(INITIAL_BALANCE);
        }

        for (int i = 0; i < n; i++) {
            String[] parts = getParsedLine(i);
            int left = Integer.parseInt(parts[0]);
            int right = Integer.parseInt(parts[1]);
            balance.set(left - 1, balance.get(left - 1) + BALANCE_INCREMENT);
            balance.set(right, balance.get(right) + BALANCE_DECREMENT);
        }

        int currentThickness = 0;
        List<Integer> thickness = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            currentThickness += balance.get(i);
            thickness.add(currentThickness);
        }
        return thickness;
    }

    private String[] getParsedLine(int index) {
        if (!parsedLinesCache.containsKey(index)) {
            parsedLinesCache.put(index, fileLines.get(index).split("\\s+"));
        }
        return parsedLinesCache.get(index);
    }

    @Override
    public void printThickness(List<Integer> thickness) {
        for (int i = 0; i < m; i++) {
            int query = pointsOfInterest.get(i);
            System.out.println("Thickness of sock coating at point " + query + ": " + thickness.get(query - 1));
        }
    }
}
