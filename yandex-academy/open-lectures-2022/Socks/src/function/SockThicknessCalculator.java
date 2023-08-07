package function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SockThicknessCalculator implements SockThicknessCalculatorInterface {
    private int l;
    private int n;
    private int m;
    private String filePath;
    private int[] pointsOfInterest;

    public SockThicknessCalculator(int l, int n, int m, String filePath, int[] pointsOfInterest) {
        this.l = l;
        this.n = n;
        this.m = m;
        this.filePath = filePath;
        this.pointsOfInterest = pointsOfInterest;
    }

    @Override
    public int[] calculateThickness() {
        int[] balance = new int[l + 1];

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                String[] parts = line.split("\\s+");
                int left = Integer.parseInt(parts[0]);
                int right = Integer.parseInt(parts[1]);
                balance[left - 1] += 1;
                balance[right] -= 1;
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return null;
        }

        int now = 0;
        int[] thickness = new int[l];

        for (int i = 0; i < l; i++) {
            now = now + balance[i];
            thickness[i] = now;
        }
        return thickness;
    }

    @Override
    public void printThickness(int[] thickness) {
        for (int i = 0; i < m; i++) {
            int query = pointsOfInterest[i];
            System.out.println("Thickness of sock coating at point " + query + ": " + thickness[query - 1]);
        }
    }
}
