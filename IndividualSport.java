package com.mycompany.sportsclubsystem;

public class IndividualSport extends SportsActivity {

    private boolean personalCoach;
    private double equipmentFee;

    public IndividualSport(int activityId, String activityName,
                           double baseFee, int maxCapacity,
                           Coach coach, Schedule schedule,
                           boolean personalCoach, double equipmentFee) {
        super(activityId, activityName, baseFee, maxCapacity, coach, schedule);
        this.personalCoach = personalCoach;
        this.equipmentFee = equipmentFee;
    }

    @Override
    public double calculateTotalFee() {
        return getBaseFee() + equipmentFee;
    }

    public boolean isPersonalCoach() {
        return personalCoach;
    }

    public void setPersonalCoach(boolean personalCoach) {
        this.personalCoach = personalCoach;
    }

    public double getEquipmentFee() {
        return equipmentFee;
    }

    public void setEquipmentFee(double equipmentFee) {
        this.equipmentFee = equipmentFee;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nPersonal Coach: " + personalCoach +
               "\nEquipment Fee: " + equipmentFee +
               "\nTotal Fee: " + calculateTotalFee();
    }
}
