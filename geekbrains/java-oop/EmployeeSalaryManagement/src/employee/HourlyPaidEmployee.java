package employee;

public class HourlyPaidEmployee extends Employee {
    private static final double MONTHLY_SALARY_COEFFICIENT = 20.8 * 8;
    private final int hourlyWage;

    public HourlyPaidEmployee(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public int calculateMonthlyAverageSalary() {
        return (int) Math.round(this.hourlyWage * MONTHLY_SALARY_COEFFICIENT);
    }

    @Override
    public String toString() {
        return "Type: Hourly paid employee. Hourly rate: " + hourlyWage;
    }
}
