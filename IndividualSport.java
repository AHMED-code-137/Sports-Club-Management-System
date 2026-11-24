
public class IndividualSport extends SportsActivity {

    // Additional attributes
    private boolean personalCoach;
    private double equipmentFee;

    // Constructor
    public IndividualSport(int activityId, String activityName,
                           double baseFee, int maxCapacity,
                           Coach coach, Schedule schedule,
                           boolean personalCoach,
                           double equipmentFee) {

        super(activityId, activityName, baseFee,
              maxCapacity, coach, schedule);

        this.personalCoach = personalCoach;
        this.equipmentFee = equipmentFee;
    }

    // Calculate total fee
    @Override
    public double calculateTotalFee() {
        return getBaseFee() + equipmentFee;
    }

    // Getters and Setters
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

    // Display information
    @Override
    public String toString() {
        return super.toString() +
               "\nPersonal Coach: " + personalCoach +
               "\nEquipment Fee: " + equipmentFee +
               "\nTotal Fee: " + calculateTotalFee();
    }
}
