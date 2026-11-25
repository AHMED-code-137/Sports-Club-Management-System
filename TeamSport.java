package com.mycompany.sportsclubsystem;
public class TeamSport extends SportsActivity {

    // Additional attributes
    private int teamSize;
    private int courtNum;

    // Constructor
    public TeamSport(int activityId, String activityName,
                     double baseFee, int maxCapacity,
                     Coach coach, Schedule schedule,
                     int teamSize, int courtNum) {

        super(activityId, activityName, baseFee,
              maxCapacity, coach, schedule);

        this.teamSize = teamSize;
        this.courtNum = courtNum;
    }

    // Calculate total fee
    @Override
    public double calculateTotalFee() {
        return getBaseFee();
    }

    // Getters and Setters
    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getCourtNum() {
        return courtNum;
    }

    public void setCourtNum(int courtNum) {
        this.courtNum = courtNum;
    }

    // Display information
    @Override
    public String toString() {
        return super.toString() +
               "\nTeam Size: " + teamSize +
               "\nCourt Number: " + courtNum +
               "\nTotal Fee: " + calculateTotalFee();
    }
}
