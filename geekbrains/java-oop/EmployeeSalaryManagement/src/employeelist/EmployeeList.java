package employeelist;

import employee.Employee;
import java.util.ArrayList;
import java.util.Iterator;
import comparator.EmployeeComparator;

public class EmployeeList implements Iterable<Employee> {
    private final ArrayList<Employee> employees;

    public EmployeeList() {
        this.employees = new ArrayList<>();
    }

    public void printAllEmployees() {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        sb.append("List of employees:\n");

        for (Employee employee : employees) {
            sb.append(counter)
                    .append(". ")
                    .append(employee.toString())
                    .append(". Average monthly salary: ")
                    .append(employee.calculateMonthlyAverageSalary())
                    .append(" rub.\n");
            counter++;
        }
        System.out.println(sb);
    }

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    public void sort(EmployeeComparator comparator) {
        this.employees.sort(comparator::compare);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new EmployeeIterator();
    }

    private class EmployeeIterator implements Iterator<Employee> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < employees.size();
        }

        @Override
        public Employee next() {
            return employees.get(currentIndex++);
        }
    }
}
