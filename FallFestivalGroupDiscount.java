// Chapter 5(Instructor Created Problem)

// Filename: FallFestivalGroupDiscount.java
// Written by: Alexander Santana
// Created: 11/4/2024

import java.util.Scanner;

public class FallFestivalGroupDiscount {


    // Main method where the program starts
    public static void main(String[] args) {
        // Make a scanner to get user input
        Scanner scanner = new Scanner(System.in);


        // Set up variables we need to use
        int groupSize; // store how many people in group
        double festivalPrice = 5.00; // price per person
        double discountPercentage; // how much discount they get
        double groupPrice; // total price for everyone

        
        // Show welcome message and festival hours
        displayGreeting();

        // Ask user to enter the group size
        System.out.print("\nHow many people are in the group? ");
        groupSize = scanner.nextInt(); // get group size from user

        // Find out what discount to give based on group size
        discountPercentage = determineGroupRate(groupSize);

        // Calculate the total price for the group including any discounts
        groupPrice = calculateGroupPrice(groupSize, discountPercentage, festivalPrice);

        // Show all the info back to the user (like size, discount, and price)
        displayInfo(groupSize, discountPercentage, festivalPrice, groupPrice);

        // Close scanner so we don't waste memory or something
        scanner.close();
    }


    // Display welcome and hours
    public static void displayGreeting() {
        System.out.println("Welcome to the Fall Festival!");
        System.out.println("Festival hours are Monday - Saturday noon - 8pm.");
    }

    // Figure out the discount amount depending on how many ppl in group
    public static double determineGroupRate(int groupSize) {
        double discount = 0; // start with no discount

        // if group is between 10-19, give 5% discount
        if (groupSize >= 10 && groupSize <= 19) {
            discount = 5;
        } else if (groupSize >= 20 && groupSize <= 29) { // if group is 20-29, give 10%
            discount = 10;
        } else if (groupSize >= 30) { // if 30 or more ppl, give max discount, 15%
            discount = 15;
        }

        return discount; // return the discount percentage
    }


    // Calculates total price for the group after discount
    public static double calculateGroupPrice(int groupSize, double discountPercentage, double festivalPrice) {
        // Figure out the discount multiplier. like if discount is 5%, multiplier is 95%
        double discountMultiplier = 1 - (discountPercentage / 100);
        // Calculate total cost for all ppl in group
        return groupSize * festivalPrice * discountMultiplier;
    }


    // Show the results/info for the user to see
    public static void displayInfo(int groupSize, double discountPercentage, double festivalPrice, double groupPrice) {
        // Calculate discount in dollar amount for the whole group
        double discountAmount = groupSize * festivalPrice * (discountPercentage / 100);



        // Print all the info, make sure it looks nice
        System.out.println();
        System.out.printf("Group Size:              %d\n", groupSize); // how many ppl in group
        System.out.printf("Festival price:          $ %.2f\n", festivalPrice); // price per person
        System.out.printf("Discount rate:           %.0f %%\n", discountPercentage); // how much discount percent
        System.out.printf("Discount amount:         $ %.2f\n", discountAmount); // discount in dollars
        System.out.printf("Group price:             $ %.2f\n", groupPrice); // total price after discount

        // say thanks to user for visiting the festival
        System.out.println("\nThank you for your interest in the fall festival!");
    }
}
