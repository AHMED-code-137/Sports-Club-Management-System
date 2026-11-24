
public abstract class SportsActivity implements Payable, Schedulable,
        Comparable<SportsActivity> {

    // Attributes
    private int activityId;
    private String activityName;
    private double baseFee;
    private int maxCapacity;
    private Coach coach;
    private Schedule schedule;

    // Constructor
    public SportsActivity(int activityId, String activityName,
                          double baseFee, int maxCapacity,
                          Coach coach, Schedule schedule) {

        this.activityId = activityId;
        this.activityName = activityName;
        this.baseFee = baseFee;
        this.maxCapacity = maxCapacity;
        this.coach = coach;
        this.schedule = schedule;
    }

    // Abstract method
    @Override
    public abstract double calculateTotalFee();

    // Process payment
    @Override
    public boolean processPayment(double amount) {

        if (amount <= 0) {
            return false;
        }

        return amount >= calculateTotalFee();
    }

    // Assign schedule
    @Override
    public void assignSchedule(Schedule s) {
        this.schedule = s;
    }

    // Get schedule details
    @Override
    public String getScheduleDetails() {

        if (schedule == null) {
            return "No schedule assigned";
        }

        return schedule.getScheduleDetails();
    }

    // Compare activities by name
    @Override
    public int compareTo(SportsActivity other) {
        return this.activityName.compareToIgnoreCase(
                other.activityName);
    }

    // Getters and Setters
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

    // Display information
    @Override
    public String toString() {
        return "Activity ID: " + activityId +
               "\nActivity Name: " + activityName +
               "\nBase Fee: " + baseFee +
               "\nMaximum Capacity: " + maxCapacity;
    }
}
