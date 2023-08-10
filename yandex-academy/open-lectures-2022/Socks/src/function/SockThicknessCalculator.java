package function;

import exceptions.FileReadingException;

import java.io.BufferedReader;
import java.io.FileReader;
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

    @Override
    public List<Integer> calculateThickness() throws FileReadingException {
        List<Integer> balance = new ArrayList<>(l + 1);
        for (int i = 0; i <= l; i++) {
            balance.add(0);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                String[] parts = line.split("\\s+");
                int left = Integer.parseInt(parts[0]);
                int right = Integer.parseInt(parts[1]);
                balance.set(left - 1, balance.get(left - 1) + 1);
                balance.set(right, balance.get(right) - 1);
            }
        } catch (IOException e) {
            throw new FileReadingException("Error reading the file: " + filePath, e);
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
