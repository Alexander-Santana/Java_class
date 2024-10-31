// Project 2, Weighted Average Program
// Filename: Project2.java
// Writtem by: Alexander Santana
// Date: 10/29/2024

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Project2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants representing the percentage weight of each grade category
        final double TRAINING_PERCENT = 0.10;
        final double LABS_PERCENT = 0.20;
        final double PROJECTS_PERCENT = 0.40;
        final double TEST_PERCENT = 0.30;

        // Variables to hold student details and grade averages
        String studentName;
        String studentID;
        double trainingAvg = 0, labsAvg = 0, projectsAvg = 0, testAvg = 0;
        // Flags to check if each category grade has been entered
        boolean enteredTraining = false, enteredLabs = false, enteredProjects = false, enteredTest = false;

        // Prompt the user to enter student's name and ID
        System.out.print("Enter student's first and last name: ");
        studentName = input.nextLine();
        
        System.out.print("Enter student's ID: ");
        studentID = input.nextLine();

        // Start a loop to keep asking for grade categories until the user chooses to stop
        boolean continueEntering = true;
        while (continueEntering) {
            // Display a menu for grade category selection
            System.out.println("\nSelect a category to enter the grade:");
            System.out.println("1. Training\n2. Labs\n3. Projects\n4. Test");
            System.out.print("Enter your choice (1-4): ");
            int choice = input.nextInt();

            // Use a switch statement to handle each category based on user choice
            switch (choice) {
                case 1:
                    // Check if the Training grade has already been entered
                    if (!enteredTraining) {
                        System.out.print("Enter Training category average: ");
                        trainingAvg = input.nextDouble();
                        enteredTraining = true; // Mark Training as entered
                    } else {
                        System.out.println("Training grade has already been entered.");
                    }
                    break;
                case 2:
                    // Check if the Labs grade has already been entered
                    if (!enteredLabs) {
                        System.out.print("Enter Labs category average: ");
                        labsAvg = input.nextDouble();
                        enteredLabs = true; // Mark Labs as entered
                    } else {
                        System.out.println("Labs grade has already been entered.");
                    }
                    break;
                case 3:
                    // Check if the Projects grade has already been entered
                    if (!enteredProjects) {
                        System.out.print("Enter Projects category average: ");
                        projectsAvg = input.nextDouble();
                        enteredProjects = true; // Mark Projects as entered
                    } else {
                        System.out.println("Projects grade has already been entered.");
                    }
                    break;
                case 4:
                    // Check if the Test grade has already been entered
                    if (!enteredTest) {
                        System.out.print("Enter Test category average: ");
                        testAvg = input.nextDouble();
                        enteredTest = true; // Mark Test as entered
                    } else {
                        System.out.println("Test grade has already been entered.");
                    }
                    break;
                default:
                    // Handle invalid category input
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    continue;
            }

            // Ask if the user wants to continue entering grades
            System.out.print("Do you want to enter another category grade? (y/n): ");
            char continueChoice = input.next().toLowerCase().charAt(0);
            continueEntering = (continueChoice == 'y'); // Continue if user enters 'y'
        }

        // Calculate the weighted average based on entered grades and category weights
        double weightedAverage = (trainingAvg * TRAINING_PERCENT) +
                                 (labsAvg * LABS_PERCENT) +
                                 (projectsAvg * PROJECTS_PERCENT) +
                                 (testAvg * TEST_PERCENT);

        // Determine the letter grade based on the weighted average
        char letterGrade;
        if (weightedAverage >= 90) letterGrade = 'A';
        else if (weightedAverage >= 80) letterGrade = 'B';
        else if (weightedAverage >= 70) letterGrade = 'C';
        else if (weightedAverage >= 60) letterGrade = 'D';
        else letterGrade = 'F';

        // Determine if the student has passed (passing is a score of 60 or higher)
        String passStatus = (weightedAverage >= 60) ? "Pass" : "Fail";

        // Display the results to the screen
        displayResults(studentName, studentID, trainingAvg, labsAvg, projectsAvg, testAvg, weightedAverage, letterGrade, passStatus);

        // Write the student's data to a file
        try (PrintWriter writer = new PrintWriter(new FileWriter("Project2Grades.txt", true))) {
            // Append student details and grade report to the file
            writer.println("Student Grade Report");
            writer.println("Student Name: " + studentName);
            writer.println("Student ID: " + studentID);
            writer.println("Training Average: " + trainingAvg);
            writer.println("Labs Average: " + labsAvg);
            writer.println("Projects Average: " + projectsAvg);
            writer.println("Test Average: " + testAvg);
            writer.println("Weighted Average: " + weightedAverage);
            writer.println("Letter Grade: " + letterGrade);
            writer.println("Pass Status: " + passStatus);
            writer.println("=====================================");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace(); // Print stack trace for debugging
        }

        // Read and display the contents of the file
        displayFileContents("Project2Grades.txt");

        // Close the scanner
        input.close();
    }

    // Method to display the results in a formatted way
    private static void displayResults(String studentName, String studentID, double trainingAvg, double labsAvg, double projectsAvg, double testAvg, double weightedAverage, char letterGrade, String passStatus) {
        System.out.println("\nStudent Grade Report:");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Training Average: " + trainingAvg);
        System.out.println("Labs Average: " + labsAvg);
        System.out.println("Projects Average: " + projectsAvg);
        System.out.println("Test Average: " + testAvg);
        System.out.println("Weighted Average: " + weightedAverage);
        System.out.println("Letter Grade: " + letterGrade);
        System.out.println("Pass Status: " + passStatus);
    }

    // Method to read and display the contents of the grade file
    private static void displayFileContents(String filename) {
        try (Scanner fileScanner = new Scanner(new java.io.File(filename))) {
            // Loop through each line in the file and print it to the screen
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace(); // Print stack trace for debugging
        }
    }
}
