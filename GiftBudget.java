// Chapter 7 Hands on Program
//Filenames: GiftBudget.java
//Programmer: Alexander Santana
//Date: 12-3-2024

import java.util.Scanner;

public class GiftBudget {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Greeting and prompt for customer's name
        System.out.println("Hello, welcome to the gift budget program!");  // Be polite, say hi
        System.out.print("What is your name? ");  // Everyone likes to feel specahl by typing their name
        String customerName = input.nextLine();  // Store the name...because we car

        // Initialize arrays for three gifts
        // One array to keep track of who we're gifting
        String[] recipients = new String[3];
        // Another to remember what we're gifting 
        String[] descriptions = new String[3];
        // And of course, the price, because gifts don't grow on trees
        double[] prices = new double[3];
        
        // Loop to collect input for each gift
        for (int i = 0; i < 3; i++) {
            // Prompt for the recipient's name 
            System.out.print("\nWho is the gift for? ");
            recipients[i] = input.nextLine();  // Store the lucky recipient
            
            // Prompt for the gift description
            System.out.print("What is the gift's item? ");
            descriptions[i] = input.nextLine();  // Store what you're buying
            
            // Prompt for the price (brace yourself, this part may hurt)
            System.out.print("What is the gift's price? ");
            prices[i] = input.nextDouble();  // Store the price of this magnificent item, lol
            input.nextLine();  // Clear the buffer 
        }
        
        // Display formatted output
        double totalSpent = 0;  // Starting with $0.00 because we're responsible adults
        System.out.println("\nGift Budget for " + customerName);  // Start the budget report
        System.out.println("--------------------------------------");  // A dashing amount of dashes
        System.out.println();  // This code just makes a blank line.... to make it look pretty
        
        // Display table headers, because data without labels is p[ure maddness 
        System.out.printf("%-12s %-12s %-12s%n", "Gift for", "Item", "Price");
        System.out.println("--------------------------------------");  // Dashes some more
        
        // Loop to display each gift's details
        for (int i = 0; i < 3; i++) {
            totalSpent += prices[i];  // Add the price to the total, because....math
            System.out.printf("%-12s %-12s $%,.2f%n", recipients[i], descriptions[i], prices[i]);  
            // Print gift info all nice looking
        }
        
        System.out.println("--------------------------------------");  // Wrap it up with one 
        System.out.printf("The total is: $%,.2f%n", totalSpent);  // Finally, the grand total christmas cost 

        input.close();
    }
}
