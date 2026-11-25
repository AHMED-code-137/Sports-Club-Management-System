package com.mycompany.sportsclubsystem;

public class FitnessClass extends SportsActivity {

    private String intensity;
    private int roomNumber;

    public FitnessClass(int activityId, String activityName,
                        double baseFee, int maxCapacity,
                        Coach coach, Schedule schedule,
                        String intensity, int roomNumber) {
        super(activityId, activityName, baseFee, maxCapacity, coach, schedule);
        this.intensity = intensity;
        this.roomNumber = roomNumber;
    }

    @Override
    public double calculateTotalFee() {
        return getBaseFee();
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nIntensity: " + intensity +
               "\nRoom Number: " + roomNumber +
               "\nTotal Fee: " + calculateTotalFee();
    }
}
