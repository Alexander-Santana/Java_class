// Chapter 4, (instructor created problem) 
// Filename: FallFestivalCalculator.java
// Written by: Alexander Santana
// Created: October 20, 2024

import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FallFestivalTickets {
    public static void main(String[] args) {
        // These are the prices for the tickets
        final double ADULT_PRICE = 8.00;  // $8 for adults
        final double CHILD_PRICE = 5.00;  // $5 for children
        
        // Variables for counting the number of adults and kids
        int numAdults, numChildren;
        String customerName, customerEmail;  // Store the name and email of the customer

        // Create a Scanner object to get inputs from the user
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // Random number generator for door prizes

        // This is the name of the file we will write the tickets to
        String fileName = "FallFestivalTicket.txt";
        
        // This boolean will control the loop that lets us add more customers
        boolean continueAdding = true;
        int ticketNumber = 1; // Start the ticket numbering at 1

        while (continueAdding) {
            // Reset number of adults and children for each new ticket
            numAdults = 0;
            numChildren = 0;

            // Get customer's name and email for their ticket
            System.out.print("Enter the customer's name: ");
            customerName = scanner.nextLine();
            System.out.print("Enter the customer's email address: ");
            customerEmail = scanner.nextLine();
            
            // Ask how many adults are attending the festival
            System.out.print("Enter the number of adults attending: ");
            numAdults = scanner.nextInt(); 
            
            // If there are adults, check if any children will be attending
            if (numAdults > 0) {
                // Ask if they are bringing children
                System.out.print("Are there any children attending? (Y for yes, n for no): ");
                char childrenAttending = scanner.next().charAt(0);  // Get the first character of their response
                if (childrenAttending == 'Y' || childrenAttending == 'y') {
                    System.out.print("Enter the number of children attending: ");
                    numChildren = scanner.nextInt(); 
                }
            } else {
                // If no adults, the children can't attend
                System.out.println("Children cannot attend without adult supervision.");
            }

            // Create a random number for the door prize
            int randomNumber = random.nextInt(10000) + 1; // Random number between 1 and 10,000

            // Calculate the total prices for adults and children
            double totalAdultPrice = numAdults * ADULT_PRICE;
            double totalChildPrice = numChildren * CHILD_PRICE;
            double totalPrice = totalAdultPrice + totalChildPrice; // Add them together for total

            // Display the ticket details to the screen
            System.out.println("\nFall Festival Ticket #" + ticketNumber); // Add ticket number here
            System.out.println("----------------------------");
            System.out.printf("Door Prize Entry #     %d\n", randomNumber);
            System.out.printf("Customer Name        %s\n", customerName);
            System.out.printf("Customer Email       %s\n", customerEmail);
            System.out.printf("Number of Adults     %d\n", numAdults);
            if (numChildren > 0) { // Only print this if they have kids
                System.out.printf("Number of Children    %d\n", numChildren);
            }
            System.out.printf("Total for Adults     $%.2f\n", totalAdultPrice);
            System.out.printf("Total for Children   $%.2f\n", totalChildPrice);
            System.out.println("----------------------------");
            System.out.printf("Total Price          $%.2f\n", totalPrice);
            System.out.println("Enjoy the festival and we hope you have a good time!");

            // Now we will write the ticket details to the file
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
                // Same output but to a file this time
                printWriter.println("Fall Festival Ticket #" + ticketNumber);
                printWriter.println("----------------------------");
                printWriter.printf("Door Prize Entry #     %d\n", randomNumber);
                printWriter.printf("Customer Name        %s\n", customerName);
                printWriter.printf("Customer Email       %s\n", customerEmail);
                printWriter.printf("Number of Adults     %d\n", numAdults);
                if (numChildren > 0) {  // Print the number of children only if there are some
                    printWriter.printf("Number of Children    %d\n", numChildren);
                }
                printWriter.printf("Total for Adults     $%.2f\n", totalAdultPrice);
                printWriter.printf("Total for Children   $%.2f\n", totalChildPrice);
                printWriter.println("----------------------------");
                printWriter.printf("Total Price          $%.2f\n", totalPrice);
                printWriter.println();
                printWriter.println("Enjoy the festival and we hope you have a good time!");  // Don't forget this
                printWriter.println(); // Leave a space between tickets
            } catch (IOException e) {
                // If something goes wrong with the file, this message is shown
                System.out.println("An error occurred while writing to the file.");
            }

            // Increase the ticket number by 1 for the next customer
            ticketNumber++;

            // Ask if the user wants to add another customer
            System.out.print("Would you like to add another ticket? (y/n): ");
            char continueInput = scanner.next().charAt(0); // Get y or n
            scanner.nextLine(); // Consume the newline character
            if (continueInput == 'n' || continueInput == 'N') {  // If 'n', stop the loop
                continueAdding = false;  // Set flag to false to end loop
            }
        }

        // Close the scanner at the end of the program to free up resources
        scanner.close();
    }
}
