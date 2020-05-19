package com.javarush.task.task29.task2909.human;

public class Worker extends Human {
    private double salary;

    private String company;

    // constructor
    public Worker(String name, int age) {
        super(name, age);
    }

    // getters & setters
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // methods
    public void live() {
        live();
    }


}