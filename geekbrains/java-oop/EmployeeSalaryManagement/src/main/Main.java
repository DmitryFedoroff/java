package main;

import employee.*;
import employeelist.EmployeeList;
import comparator.SalaryComparator;

public class Main {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        employeeList.add(new HourlyPaidEmployee(20));
        employeeList.add(new FixedSalaryEmployee(2000));
        employeeList.add(new HourlyPaidEmployee(25));
        employeeList.add(new FixedSalaryEmployee(2200));
        employeeList.add(new HourlyPaidEmployee(30));
        employeeList.add(new FixedSalaryEmployee(2500));
        employeeList.add(new HourlyPaidEmployee(15));
        employeeList.add(new FixedSalaryEmployee(1500));
        employeeList.add(new HourlyPaidEmployee(18));
        employeeList.add(new FixedSalaryEmployee(2100));
        employeeList.sort(new SalaryComparator());
        employeeList.printAllEmployees();
    }
}
