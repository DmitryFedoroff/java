public class Main {

    public static void main(String[] args) {
        NatNumInputValidator natNumInputValidator = new NatNumInputValidator();

        System.out.print("Enter initial investment: ");
        int investment = natNumInputValidator.validate();

        System.out.print("Enter number of days: ");
        int days = natNumInputValidator.validate();

        DailyPriceInputValidator dailyPriceInputValidator = new DailyPriceInputValidator(days);

        System.out.print("Enter prices of gas on each day separated by space: ");
        int[] prices = dailyPriceInputValidator.validate();

        TradingDayFinder tradingDayFinder = new TradingDayFinder();
        int[] result = tradingDayFinder.find(days, investment, prices);

        System.out.println("Numbers of days for buying and selling gas: " + result[0] + " " + result[1]);
        System.out.println("Max revenue: " + result[2]);

        natNumInputValidator.closeScanner();
        dailyPriceInputValidator.closeScanner();
    }
}