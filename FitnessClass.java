
public class FitnessClass extends SportsActivity {

    // Additional attributes
    private String intensity;
    private int roomNumber;

    // Constructor
    public FitnessClass(int activityId, String activityName,
                        double baseFee, int maxCapacity,
                        Coach coach, Schedule schedule,
                        String intensity, int roomNumber) {

        super(activityId, activityName, baseFee,
              maxCapacity, coach, schedule);

        this.intensity = intensity;
        this.roomNumber = roomNumber;
    }

    // Calculate total fee
    @Override
    public double calculateTotalFee() {
        return getBaseFee();
    }

    // Getters and Setters
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

    // Display information
    @Override
    public String toString() {
        return super.toString() +
               "\nIntensity: " + intensity +
               "\nRoom Number: " + roomNumber +
               "\nTotal Fee: " + calculateTotalFee();
    }
}
