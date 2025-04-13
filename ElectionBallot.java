//Chapter 11, ElectionBallot
//Filename: ElectionBallot.java
//Programmer: Alexander Santana
//Date: 4/9/2025

import java.util.InputMismatchException;
import java.util.Scanner;

public class ElectionBallot {

    public static void main(String[] args) {
    
        String[] candidates = {"Mickey Mouse", "George Washington", "Alexander the Great", "Alexander Santana", "Homer Simpson"};

        System.out.println("==*== Election Ballot ==*==");
        
        for (int i = 0; i < candidates.length; i++) {
            System.out.println((i + 1) + "-" + candidates[i]);
        }
        
        System.out.println("*===========================*");

        System.out.print("Enter the number of your candidate:");

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();
            
            System.out.println("You have chosen: " + candidates[choice - 1]);

        } catch (InputMismatchException e) {
        
            System.err.println("\nError: " + e.getMessage());
            System.err.println("Make sure you enter number that matches a candidate. No letters or symbols.");
            System.err.println("To fix issue, run again and enter a whole number.");
            
        } catch (ArrayIndexOutOfBoundsException e) {
        
            System.err.println("\nError: " + e.getMessage());
            System.err.println("Wrong selection. The number you entered is not an option.");
            System.err.println("To correct problem, please run the program again and enter a number between 1 and 5.");
        }
    }
}