// Chapter 8, Order Entry Problem
// Files: Order.java, PlaceOrder.Java, OrderType.java
// Programmer: Alexander Santana
// Date: 1/20/25


import java.util.Scanner;

// Gonna be making a class called Order to keep track of restaurant orders
public class Order {
    // These are the vars where Im gonna store all the important order info
    private String customerName;  // Name of the customer
    private String itemDescription;  // Name of the item they’re ordering
    private int quantity;  // How many of the item the customer wants
    private double price;  // Price of a single item
    private OrderType orderType; // Changed from String to OrderType
    private String address;  // The delivery address (or the pickup place)
    private double deliveryCharge;  // fee for delivery (0 if its a pickup)
    
    // New Constructor for delivery orders with a new ordertype param
    public Order(String address, double deliveryCharge, OrderType orderType) {
        this.address = address;
        this.deliveryCharge = deliveryCharge;
        this.orderType = orderType;
    

    // Constructor for delivery orders
   // public Order(String address, double deliveryCharge) {
        // Save the address the customer gave for delivery
     //   this.address = address;
        // Save the delivery charge thats gonna get added to the total
       // this.deliveryCharge = deliveryCharge;
        // Since its a delivery order, we're setting it as "delivery"
        //this.orderType = "delivery";
    }
    
    // here is the new no-arg constructor
    public Order() {
        this("1122 Restaurant Avenue", 0.0, OrderType.PICKUP);
    }

    // Constructor for pickup orders
    //public Order() {
        // For pickup orders, the address is set to the restaurants address
        //this.address = "1122 Restaurant Avenue";
        // No delivery fee for pickup orders, so it's 0
        //this.deliveryCharge = 0.0;
        // Marking this one as "pickup"
        //this.orderType = "pickup";
    //}

    // Now I'm adding setter methods so the customer can input their order info

    // This one lets the customer type in their name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // This one is for what item they want
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    // This one is for how many they want
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // This one is for the price of the item
    public void setPrice(double price) {
        this.price = price;
    }

    // Now the method, its gonna calculate the total cost of the order
    public double calculateOrderTotal() {
        // The total is price * quantity, plus delivery fee if there is one
        return (price * quantity) + deliveryCharge;
    }
    
    //the accessor method 
    public OrderType getOrderType() {
        return orderType;
    }

    // Last but not least, im gonna add a method to print all the order details while making them look good
    public void displayOrderData() {
        System.out.println("\n--------------------------------------");
        System.out.printf("%-20s %s\n", "Name:", customerName);
        System.out.printf("%-20s %s\n", "Order Type:", orderType);
        System.out.printf("%-20s %s\n", "Delivery Location:", address);
        System.out.printf("%-20s %s\n", "Item:", itemDescription);
        System.out.printf("%-20s %d\n", "Quantity:", quantity);
        System.out.printf("%-20s $%.2f\n", "Price:", price);
        System.out.printf("%-20s $%.2f\n", "Delivery Charge:", deliveryCharge);
        System.out.printf("%-20s $%.2f\n", "Total:", calculateOrderTotal());
        System.out.println("\nThanks for your order!");
    }
}
