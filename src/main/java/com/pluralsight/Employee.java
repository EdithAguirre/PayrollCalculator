package com.pluralsight;

public class Employee {
    // Data members(attributes)
    private int employeeId;
    private String name;
    private float hoursWorked;
    private float payRate;

    // Parameterized constructor
    public Employee(int employeeId, String name, float hoursWorked, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Getter and setter methods for all attributes
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    // Calculates and returns that employee's gross pay based on their hours worked and pay rate
    public double getGrossPay(){
        return hoursWorked * payRate;
    }
}
