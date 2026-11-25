package com.mycompany.sportsclubsystem;
import java.time.LocalDate;

/** A completed payment. It cannot be changed after it is created. */
public class Payment {

    public enum Method { CASH, CARD, BANK_TRANSFER }

    private static final double TOLERANCE = 0.001;
    private static int nextId = 1; // shared by all payments

    private final int paymentId;
    private final Member member;
    private final Payable item;
    private final double amount;
    private final Method method;
    private final LocalDate date;

    public Payment(Member member, Payable item, double amount, Method method)
            throws InvalidPaymentException {
        if (member == null || item == null || method == null) {
            throw new InvalidPaymentException("Member, item and payment method are required.");
        }
        double requiredFee = item.calculateFee();
        // Written this way so that NaN is rejected too.
        if (!(amount > 0 && Math.abs(amount - requiredFee) <= TOLERANCE)) {
            throw new InvalidPaymentException(
                    "Invalid amount: " + amount + ". Required fee: " + requiredFee);
        }
        this.paymentId = nextId++; // only valid payments take an ID
        this.member = member;
        this.item = item;
        this.amount = amount;
        this.method = method;
        this.date = LocalDate.now();
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Member getMember() {
        return member;
    }

    public Payable getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    public Method getMethod() {
        return method;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Payment #" + paymentId + " | " + member.getName() + " | "
                + amount + " | " + method + " | " + date;
    }
}
