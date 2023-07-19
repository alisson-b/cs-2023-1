package org.example._04;

public class Employee {
    private double salary;
    private double awards;

    public Employee(double salary, double awards) {
        this.salary = salary;
        this.awards = awards;
    }

    public void employeeMethod() {
        // Some actions
        double yearlySalary = getYearlySalary();
        double employeeAwards = getAwards();
        Salary salaryCalculator = new Salary();
        double monthlySalary = salaryCalculator.calculateMonthlySalary(yearlySalary, employeeAwards);
       // Continue processing
 	}

    public double getYearlySalary() {
        return salary * 12;
    }

    public double getAwards() {
        return awards;
    }
}
