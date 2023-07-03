package comparator;

import employee.Employee;

public class SalaryComparator implements EmployeeComparator {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.calculateMonthlyAverageSalary() - e2.calculateMonthlyAverageSalary();
    }
}

