package employee;

public class FixedSalaryEmployee extends Employee {
    private final int monthlySalary;

    public FixedSalaryEmployee(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int calculateMonthlyAverageSalary() {
        return this.monthlySalary;
    }

    @Override
    public String toString() {
        return "Type: Employee with fixed salary. Monthly salary: " + monthlySalary;
    }
}
