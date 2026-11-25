package com.mycompany.sportsclubsystem;

public class SportsClubSystem {

    public static void main(String[] args) {
        ClubManager manager = new ClubManager();

        // Pre-load sample data for quick testing & presentation demo
        try {
            Coach c1 = new Coach(101, "Kareem Adel", "0100000001", "kareem@club.com", "Football", 8000);
            Coach c2 = new Coach(102, "Sara Nabil", "0100000002", "sara@club.com", "Yoga & Fitness", 7500);
            manager.addCoach(c1);
            manager.addCoach(c2);

            Member m1 = new Member(1, "Ahmed Mohamed", "0111111111", "ahmed@mail.com", "Gold");
            Member m2 = new Member(2, "Mona Tarek", "0122222222", "mona@mail.com", "Silver");
            manager.addMember(m1);
            manager.addMember(m2);

            Schedule s1 = new Schedule(1, "Sunday", "05:00 PM", "07:00 PM");
            Schedule s2 = new Schedule(2, "Tuesday", "06:00 PM", "07:30 PM");

            SportsActivity a1 = new TeamSport(201, "Football", 300.0, 22, c1, s1, 11, 1);
            SportsActivity a2 = new FitnessClass(202, "Aerobics", 200.0, 15, c2, s2, "High", 3);
            SportsActivity a3 = new IndividualSport(203, "Tennis", 400.0, 2, c1, s1, true, 50.0);

            manager.addActivity(a1);
            manager.addActivity(a2);
            manager.addActivity(a3);

        } catch (Exception e) {
            System.out.println("Error loading initial data: " + e.getMessage());
        }

        // Start the User Interface
        ClubUI ui = new ClubUI(manager);
        ui.showMainMenu();
    }
}
