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

public class Member extends Person {

    private String membership;
    private List<SportsActivity> activities;

    public Member(int id, String name, String phone, String email, String membership) {
        super(id, name, phone, email);
        this.membership = membership;
        this.activities = new ArrayList<>();
    }

    public void register(SportsActivity a) {
        if (a == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }
        if (!activities.contains(a)) {
            activities.add(a);
        }
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Member (" + membership + ")");
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public List<SportsActivity> getActivities() {
        return new ArrayList<>(activities); 
    }

    @Override
    public String toString() {
        return super.toString() + ", Membership: " + membership + ", Activities: " + activities.size();
    }
}
