/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sportsclubsystem;

/**
 *
 * @author Ahmed
 */
import java.util.ArrayList;
import java.util.List;

public class Coach extends Person {

    private String specialty;
    private double salary;
    private List<SportsActivity> assignedActivities;

    public Coach(int id, String name, String phone, String email,
                 String specialty, double salary) {
        super(id, name, phone, email);
        this.specialty = specialty;
        this.salary = salary;
        this.assignedActivities = new ArrayList<>();
    }

    // Assign an activity to this coach (no duplicates)
    public void assignActivity(SportsActivity a) {
        if (a == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }
        if (!assignedActivities.contains(a)) {
            assignedActivities.add(a);
        }
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Coach (" + specialty + ")");
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public List<SportsActivity> getAssignedActivities() {
        return new ArrayList<>(assignedActivities);
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialty: " + specialty + ", Salary: " + salary + ", Activities: " + assignedActivities.size();
    }
}
