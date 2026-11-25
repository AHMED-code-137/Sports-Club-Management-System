package com.mycompany.sportsclubsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class ClubManager {

    private final List<Member> members = new ArrayList<>();
    private final List<Coach> coaches = new ArrayList<>();
    private final List<SportsActivity> activities = new ArrayList<>();
    private final List<Payment> payments = new ArrayList<>();

    // ---------- Members ----------

    public void addMember(Member member) {
        requireNotNull(member, "Member");
        for (Member existing : members) {
            if (existing.getId() == member.getId()) {
                throw new IllegalArgumentException("Member ID already exists: " + member.getId());
            }
        }
        members.add(member);
    }

    public Member findMemberById(int id) throws MemberNotFoundException {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        throw new MemberNotFoundException("No member with ID: " + id);
    }

    public void removeMember(int id) throws MemberNotFoundException {
        Member member = findMemberById(id);
        for (SportsActivity activity : activities) {
            activity.removeMember(member);
        }
        members.remove(member);
    }

    // ---------- Coaches ----------

    public void addCoach(Coach coach) {
        requireNotNull(coach, "Coach");
        for (Coach existing : coaches) {
            if (existing.getId() == coach.getId()) {
                throw new IllegalArgumentException("Coach ID already exists: " + coach.getId());
            }
        }
        coaches.add(coach);
    }

    // ---------- Activities ----------

    public void addActivity(SportsActivity activity) {
        requireNotNull(activity, "Activity");
        for (SportsActivity existing : activities) {
            if (existing.getId() == activity.getId()) {
                throw new IllegalArgumentException("Activity ID already exists: " + activity.getId());
            }
        }
        activities.add(activity);
    }

    public SportsActivity findActivityById(int id) {
        for (SportsActivity activity : activities) {
            if (activity.getId() == id) {
                return activity;
            }
        }
        throw new NoSuchElementException("No activity with ID: " + id);
    }

    public void enrollMember(int memberId, int activityId)
            throws MemberNotFoundException, ActivityFullException {
        Member member = findMemberById(memberId);
        SportsActivity activity = findActivityById(activityId);
        activity.addMember(member);
    }

    public List<SportsActivity> getSortedActivities() {
        List<SportsActivity> copy = new ArrayList<>(activities);
        SortUtil.sort(copy);
        return copy;
    }

    public List<SportsActivity> getSortedActivities(Comparator<? super SportsActivity> comparator) {
        List<SportsActivity> copy = new ArrayList<>(activities);
        SortUtil.sort(copy, comparator);
        return copy;
    }

    // ---------- Payments ----------

    public Payment processPayment(int memberId, int activityId, double amount, Payment.Method method)
            throws MemberNotFoundException, InvalidPaymentException {
        Member member = findMemberById(memberId);
        SportsActivity activity = findActivityById(activityId);
        Payment payment = new Payment(member, activity, amount, method);
        payments.add(payment);
        return payment;
    }

    public double getTotalRevenue() {
        double total = 0;
        for (Payment payment : payments) {
            total += payment.getAmount();
        }
        return total;
    }

    // ---------- Read-only views ----------

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    public List<SportsActivity> getActivities() {
        return Collections.unmodifiableList(activities);
    }

    public List<Payment> getPayments() {
        return Collections.unmodifiableList(payments);
    }

    private static void requireNotNull(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }
}
