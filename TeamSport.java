package com.mycompany.sportsclubsystem;

public class TeamSport extends SportsActivity {

    private int teamSize;
    private int courtNum;

    public TeamSport(int activityId, String activityName,
                     double baseFee, int maxCapacity,
                     Coach coach, Schedule schedule,
                     int teamSize, int courtNum) {
        super(activityId, activityName, baseFee, maxCapacity, coach, schedule);
        this.teamSize = teamSize;
        this.courtNum = courtNum;
    }

    @Override
    public double calculateTotalFee() {
        return getBaseFee();
    }

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

    @Override
    public String toString() {
        return super.toString() +
               "\nTeam Size: " + teamSize +
               "\nCourt Number: " + courtNum +
               "\nTotal Fee: " + calculateTotalFee();
    }
}
