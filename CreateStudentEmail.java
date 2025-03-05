//Chapter 9, Programming Exercise
// Filename: CreateStudentEmail.com
//Programmer: Alexander Santana
// Date: 2/24/2025

import java.util.Scanner;

public class CreateStudentEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get full name input
        System.out.print("Enter students full name... ");
        String fullName = scanner.nextLine().toUpperCase(); // Convert to uppercase

        // Get student ID input
        System.out.print("Enter student ID... ");
        String studentID = scanner.nextLine();

        scanner.close();

        // Split the full name into words
        String[] nameParts = fullName.split(" ");
        String lastName = nameParts[nameParts.length - 1]; // Get last name
        char firstInitial = nameParts[0].charAt(0); // Get first initial

        // Extract last 5 digits of student ID
        int idLength = studentID.length();
        String lastFiveDigits = (idLength >= 5) ? studentID.substring(idLength - 5) : studentID;

        // Build the email using StringBuilder
        StringBuilder email = new StringBuilder();
        email.append(lastName.toLowerCase()).append(".")
             .append(Character.toLowerCase(firstInitial)).append(".")
             .append(lastFiveDigits).append("@student.rccc.edu");

        // Output results
        System.out.println("\nStudent Name: " + fullName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Email Address: " + email);
    }
}