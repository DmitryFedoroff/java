class TradingDayFinder {

    public int[] find(int n, int amount, int[] cost) {
        int minIndex = 0;
        double maxGas = amount / (double) cost[0];
        int maxRevenue = 0;
        int[] tradingDays = new int[2];

        for (int i = 1; i < n; i++) {
            if (maxGas * cost[i] - amount > maxRevenue) {
                maxRevenue = (int) (maxGas * cost[i] - amount);
                tradingDays[0] = minIndex + 1;
                tradingDays[1] = i + 1;
            }
            if (amount / (double) cost[i] > maxGas) {
                minIndex = i;
                maxGas = amount / (double) cost[i];
            }
        }

        return new int[]{tradingDays[0], tradingDays[1], maxRevenue};
    }
}