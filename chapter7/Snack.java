//Chapter 7 2D array and ArrayList
//Filename: VendingMachine2D
//Programmer: Alexander Santana
//Date modified: 1/3/2025


//So here is my class named Snack
public class Snack {
   private String name;
   private double price;


   //This is my constructer, their are many like it but this one is mine!
   public Snack(String name, double price) {
      this.name = name; //This. assigns the name to the variable 
      this.price = price;
   }
   
   //Getter method for the name of the snacky
   public String getName() {
      return name;//brings back the name of the snack 
   }
   
   //Setter method 
   public void setName(String name) {
      this.name = name; //updates the snack name, it gets and then it sets....
   }
   
   //same getter/setter method but for price
   public double getPrice() {
      return price;
   }
   
   //Setter method 
   public void setPrice(double price) {
      this.price = price;
   }
}