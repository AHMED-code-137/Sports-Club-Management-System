/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sportsclubsystem;

public class Schedule {
    private int scheduleId;
    private String dayOfWeek;
    private String startTime;
    private String endTime;

    public Schedule(int scheduleId, String dayOfWeek, String startTime, String endTime) {
        this.scheduleId = scheduleId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getScheduleDetails() {
        return "Schedule #" + scheduleId + ": " + dayOfWeek + " (" + startTime + " - " + endTime + ")";
    }

    // Getters and Setters (Encapsulation)
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return getScheduleDetails();
    }
}
