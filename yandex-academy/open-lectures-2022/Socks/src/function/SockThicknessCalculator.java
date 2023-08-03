package function;

import java.util.List;

public class SockThicknessCalculator implements SockThicknessCalculatorInterface {

    private int l;
    private int n;
    private int m;
    private List<String> data;
    private int[] pointsOfInterest;

    public SockThicknessCalculator(int l, int n, int m, List<String> data, int[] pointsOfInterest) {
        this.l = l;
        this.n = n;
        this.m = m;
        this.data = data;
        this.pointsOfInterest = pointsOfInterest;
    }

    @Override
    public void calculateThickness() {
        int[] balance = new int[l + 1];

        for (int i = 0; i < n; i++) {
            String[] parts = data.get(i).split("\\s+");
            int left = Integer.parseInt(parts[0]);
            int right = Integer.parseInt(parts[1]);
            balance[left - 1] += 1;
            balance[right] -= 1;
        }

        int now = 0;
        int[] thickness = new int[l];

        for (int i = 0; i < l; i++) {
            now = now + balance[i];
            thickness[i] = now;
        }

        for (int i = 0; i < m; i++) {
            int query = pointsOfInterest[i];
            System.out.println("Thickness of sock coating at point " + query + ": " + thickness[query - 1]);
        }
    }
}
