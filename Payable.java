package com.mycompany.sportsclubsystem;

public interface Payable {
    double calculateTotalFee();
    boolean processPayment(double amount);
}
