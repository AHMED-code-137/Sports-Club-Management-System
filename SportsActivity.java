package com.mycompany.sportsclubsystem;

import java.util.ArrayList;
import java.util.List;

public abstract class SportsActivity implements Payable, Schedulable, Comparable<SportsActivity> {

    private int activityId;
    private String activityName;
    private double baseFee;
    private int maxCapacity;
    private Coach coach;
    private Schedule schedule;
    private final List<Member> enrolledMembers;

    public SportsActivity(int activityId, String activityName,
                          double baseFee, int maxCapacity,
                          Coach coach, Schedule schedule) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.baseFee = baseFee;
        this.maxCapacity = maxCapacity;
        this.coach = coach;
        this.schedule = schedule;
        this.enrolledMembers = new ArrayList<>();
    }

    @Override
    public abstract double calculateTotalFee();

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            return false;
        }
        return amount >= calculateTotalFee();
    }

    @Override
    public void assignSchedule(Schedule s) {
        this.schedule = s;
    }

    @Override
    public String getScheduleDetails() {
        if (schedule == null) {
            return "No schedule assigned";
        }
        return schedule.getScheduleDetails();
    }

    @Override
    public int compareTo(SportsActivity other) {
        return this.activityName.compareToIgnoreCase(other.activityName);
    }

    // Methods required by ClubManager for enrollment
    public void addMember(Member member) throws ActivityFullException {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if (enrolledMembers.contains(member)) {
            throw new IllegalArgumentException("Member is already enrolled in this activity.");
        }
        if (enrolledMembers.size() >= maxCapacity) {
            throw new ActivityFullException("Activity '" + activityName + "' has reached its maximum capacity (" + maxCapacity + ").");
        }
        enrolledMembers.add(member);
        member.register(this);
    }

    public void removeMember(Member member) {
        enrolledMembers.remove(member);
    }

    public List<Member> getEnrolledMembers() {
        return new ArrayList<>(enrolledMembers);
    }

    // Alias getId() for ClubManager compatibility
    public int getId() {
        return activityId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(double baseFee) {
        this.baseFee = baseFee;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Activity ID: " + activityId +
               "\nActivity Name: " + activityName +
               "\nBase Fee: " + baseFee +
               "\nCapacity: " + enrolledMembers.size() + "/" + maxCapacity;
    }
}
