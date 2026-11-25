# Sports-Club-Management-System

A complete Object-Oriented Programming (OOP) Java application designed to manage sports club operations, including members, coaches, sports activities, schedules, and payments.

## Key OOP Concepts Applied
* **Abstraction & Inheritance:** `Person` (extended by `Member` and `Coach`) and `SportsActivity` (extended by `TeamSport`, `IndividualSport`, and `FitnessClass`).
* **Polymorphism:** Dynamic fee calculation (`calculateTotalFee()`) and role display (`displayRole()`) across different subclasses.
* **Interfaces:** Custom interfaces (`Payable`, `Schedulable`) and Java's built-in `Comparable<SportsActivity>`.
* **Generic Sorting:** Sorting sports activities using `Collections.sort()` via `SortUtil`.
* **Exception Handling:** Custom exceptions (`ActivityFullException`, `InvalidPaymentException`, `MemberNotFoundException`) handled gracefully in the UI.

## Team Modules (5 Members)
1. **Student 1 (Interfaces & Scheduling):** `Payable`, `Schedulable`, `Schedule`
2. **Student 2 (People Hierarchy):** `Person`, `Member`, `Coach`
3. **Student 3 (Activities Hierarchy):** `SportsActivity`, `TeamSport`, `IndividualSport`, `FitnessClass`
4. **Student 4 (Core Management & Payments):** `Payment`, `SortUtil`, `ClubManager`
5. **Student 5 (Exceptions, UI & Entry Point):** `ActivityFullException`, `InvalidPaymentException`, `MemberNotFoundException`, `ClubUI`, `SportsClubSystem`

## How to Run
1. Clone or download the repository.
2. Open the project in **NetBeans** (or any Java IDE).
3. Run `SportsClubSystem.java` to launch the interactive console menu pre-loaded with sample data.
