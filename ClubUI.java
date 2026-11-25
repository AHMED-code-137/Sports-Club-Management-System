package com.mycompany.sportsclubsystem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClubUI {

    private final ClubManager manager;
    private final Scanner scanner;

    public ClubUI(ClubManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n==========================================");
            System.out.println("   SPORTS CLUB MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Add New Member");
            System.out.println("2. Add New Coach");
            System.out.println("3. Add New Sports Activity");
            System.out.println("4. Enroll Member in Activity");
            System.out.println("5. Process Payment");
            System.out.println("6. View All Activities (Sorted by Name)");
            System.out.println("7. View All Members & Coaches");
            System.out.println("8. View Payments & Total Revenue");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                running = handleUserInput(choice);
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    private boolean handleUserInput(int choice) {
        try {
            switch (choice) {
                case 1 -> addMemberUI();
                case 2 -> addCoachUI();
                case 3 -> addActivityUI();
                case 4 -> enrollMemberUI();
                case 5 -> processPaymentUI();
                case 6 -> viewSortedActivitiesUI();
                case 7 -> viewPeopleUI();
                case 8 -> viewPaymentsUI();
                case 0 -> {
                    System.out.println("Exiting system. Goodbye!");
                    return false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } catch (MemberNotFoundException | ActivityFullException | InvalidPaymentException e) {
            System.out.println("Operation Failed: " + e.getMessage());
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
        return true;
    }

    private void addMemberUI() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Membership Type (Gold/Silver/Regular): ");
        String type = scanner.nextLine();

        Member member = new Member(id, name, phone, email, type);
        manager.addMember(member);
        System.out.println("Member added successfully!");
    }

    private void addCoachUI() {
        System.out.print("Enter Coach ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Coach coach = new Coach(id, name, phone, email, specialty, salary);
        manager.addCoach(coach);
        System.out.println("Coach added successfully!");
    }

    private void addActivityUI() {
        System.out.println("Select Activity Type: 1. Team Sport | 2. Individual Sport | 3. Fitness Class");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Activity ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Activity Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Base Fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter Max Capacity: ");
        int cap = scanner.nextInt();
        scanner.nextLine();

        // Schedule details
        System.out.print("Enter Schedule ID: ");
        int schedId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Day of Week: ");
        String day = scanner.nextLine();
        System.out.print("Enter Start Time (e.g., 10:00 AM): ");
        String start = scanner.nextLine();
        System.out.print("Enter End Time (e.g., 12:00 PM): ");
        String end = scanner.nextLine();
        Schedule schedule = new Schedule(schedId, day, start, end);

        Coach assignedCoach = manager.getCoaches().isEmpty() ? null : manager.getCoaches().get(0);

        SportsActivity activity = switch (type) {
            case 1 -> {
                System.out.print("Enter Team Size: ");
                int teamSize = scanner.nextInt();
                System.out.print("Enter Court Number: ");
                int courtNum = scanner.nextInt();
                scanner.nextLine();
                yield new TeamSport(id, name, fee, cap, assignedCoach, schedule, teamSize, courtNum);
            }
            case 2 -> {
                System.out.print("Requires Personal Coach? (true/false): ");
                boolean pc = scanner.nextBoolean();
                System.out.print("Enter Equipment Fee: ");
                double eqFee = scanner.nextDouble();
                scanner.nextLine();
                yield new IndividualSport(id, name, fee, cap, assignedCoach, schedule, pc, eqFee);
            }
            case 3 -> {
                System.out.print("Enter Intensity Level (Low/Medium/High): ");
                String intensity = scanner.nextLine();
                System.out.print("Enter Room Number: ");
                int room = scanner.nextInt();
                scanner.nextLine();
                yield new FitnessClass(id, name, fee, cap, assignedCoach, schedule, intensity, room);
            }
            default -> throw new IllegalArgumentException("Invalid activity type selected.");
        };

        manager.addActivity(activity);
        System.out.println("Activity added successfully!");
    }

    private void enrollMemberUI() throws MemberNotFoundException, ActivityFullException {
        System.out.print("Enter Member ID: ");
        int mId = scanner.nextInt();
        System.out.print("Enter Activity ID: ");
        int aId = scanner.nextInt();
        scanner.nextLine();

        manager.enrollMember(mId, aId);
        System.out.println("Member enrolled in activity successfully!");
    }

    private void processPaymentUI() throws MemberNotFoundException, InvalidPaymentException {
        System.out.print("Enter Member ID: ");
        int mId = scanner.nextInt();
        System.out.print("Enter Activity ID: ");
        int aId = scanner.nextInt();
        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Select Payment Method: 1. CASH | 2. CARD | 3. BANK_TRANSFER");
        int methodChoice = scanner.nextInt();
        scanner.nextLine();

        Payment.Method method = switch (methodChoice) {
            case 1 -> Payment.Method.CASH;
            case 2 -> Payment.Method.CARD;
            case 3 -> Payment.Method.BANK_TRANSFER;
            default -> throw new InvalidPaymentException("Invalid payment method.");
        };

        Payment payment = manager.processPayment(mId, aId, amount, method);
        System.out.println("Payment completed: " + payment);
    }

    private void viewSortedActivitiesUI() {
        List<SportsActivity> sorted = manager.getSortedActivities();
        if (sorted.isEmpty()) {
            System.out.println("No activities available.");
            return;
        }
        System.out.println("\n--- Sorted Sports Activities ---");
        for (SportsActivity act : sorted) {
            System.out.println(act);
            System.out.println("Schedule: " + act.getScheduleDetails());
            System.out.println("--------------------------------");
        }
    }

    private void viewPeopleUI() {
        System.out.println("\n--- Club Members ---");
        for (Member m : manager.getMembers()) {
            m.displayRole();
            System.out.println(m);
        }
        System.out.println("\n--- Club Coaches ---");
        for (Coach c : manager.getCoaches()) {
            c.displayRole();
            System.out.println(c);
        }
    }

    private void viewPaymentsUI() {
        System.out.println("\n--- Payment History ---");
        for (Payment p : manager.getPayments()) {
            System.out.println(p);
        }
        System.out.println("Total Club Revenue: " + manager.getTotalRevenue());
    }
}
