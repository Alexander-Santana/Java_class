//Chapter 7 2D array and ArrayList
//Filename: VendingMachine2D
//Programmer: Alexander Santana
//Date modified: 1/3/2025

import java.util.Scanner;
import java.util.ArrayList;


public class VendingMachine2D {

   private static final String[][] snacks = { // simple little 2D array, looks like a csv file
        {"Tortilla Chips", "Potato Chips", "Trail Mix", "Snack Mix"},
        {"M&Ms Candy", "Snickers Candy", "Skittles Candy", "Reese's Candy"},
        {"Peanut Butter Crackers", "Cheese Crackers", "Oreo Cookies", "Chocolate Chip Cookies"},
        {"Peppermint Gum", "Fruit Gum", "Spearmint Gum", "Lifesavers"}
    };
    
    private static final double[] prices = {1.50, 1.25, 1.00, 0.75}; //Setting the prices based on the row
    
    private static final ArrayList<Snack> purchasedSnacks = new ArrayList<>(); //sweet bit of code that stores purchased snacks
    
    public static void main(String[] args) { //Getting the method rocking
      Scanner scanner = new Scanner(System.in); //this is the scanner for input
      
      boolean continueShopping = true; //this one controls the loop
      
      while (continueShopping) { //loop!!
         displaySnacks(); //Show em the snacks we have in the vending machine
         System.out.print("Pick a Row A-D...");
         char rowChar = scanner.next().charAt(0); //Reads the user input 
         int row = rowChar - 'A'; //changes char to index
         
         System.out.print("Pick a Column 0-3...");//read the column selection
         int column = scanner.nextInt();
         
         if (row >= 0 && row < snacks.length && column >= 0 && column < snacks[row].length) { //this if else makes sure selections are within a range
            String snackName = snacks[row][column];
            double price = prices[row]; //get the price back based on row selection
            Snack snack = new Snack(snackName, price); //lets make a new object
            purchasedSnacks.add(snack); // adding snack to the purchase list
            
            System.out.println("You picked: " + snack.getName() + " -$" + snack.getPrice() + "-");
         } 
         else {
            System.out.println("Wrong Choice!!!");
         }
         
         System.out.print("Anything Else? 1=YES, 2=NO...");
         int choice = scanner.nextInt();  // just like up top, it reads users selection
         continueShopping = (choice == 1); //if they choose 1, let them continue
         }
      
      displayTotal(); //show the customer the total 
      scanner.close(); //gotta close the scanner, cant remeber why but I know its a good idea
   }
   private static void displaySnacks() {
      System.out.println("Choose by entering row and column.");
      System.out.println("  0             1             2             3");// this will be the labels for the columns
      for (int i = 0; i < snacks.length; i++) { //this will print each snack in the snacks array, starting at 0 until it reaches the length of snacks
         System.out.print((char) ('A' + i) + " "); // this will be the row labels 
         for (String snack : snacks[i]) { //iterate through each snackin the current row
            System.out.printf("%-10s ", snack); // make it 10 charecters wide string
         }
         System.out.printf(" $ %.2f\n", prices[i]); // floating point with 2 decimals and a new line charecter combination
         }
     }
    
    
   private static void displayTotal() {
      double total = 0;
      System.out.println("items bought...");
      for (Snack snack : purchasedSnacks) { //for loop!!!
         System.out.println(snack.getName() + " - $" + snack.getPrice()); // Show items by cancatinating 
         total += snack.getPrice(); // add up the cost
      }
      System.out.println("Total Cost: $" + total); // Show the total
      }
}