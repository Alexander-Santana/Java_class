// Chapter 6
// Files: Order.java, PlaceOrder.Java'
// Programmer: Alexander Santana
// Date: 1/20/25

import java.util.Scanner;

public class PlaceOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // We gotta welcome the customer to the restaurant
        System.out.println("Welcome to the restaurant!\n");

        // Asking for the customers name, bevause why not? 
        System.out.print("Enter the customer name ");
        String customerName = scanner.nextLine();

        // Asking if it's a delivery or pickup order, gotta know the details
        System.out.println("Is this pickup or delivery?");
        System.out.println("1 - delivery");
        System.out.println("2 - pickup");
        System.out.print("> ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Order order;
        if (choice == 1) {
            // If it is gonna be a delivery order, I ask for the address
            System.out.print("\nPlease enter the delivery address ");
            String deliveryAddress = scanner.nextLine();
            // Creating the order object with delivery details
            order = new Order(deliveryAddress, 15.00, OrderType.DELIVERY);//added the orderType
        } else {
            // If it’s a pickup order, I jus create the order with defautl values
            order = new Order();
        }

        // Asking for the  details
        System.out.print("\nEnter the item ");
        String itemDescription = scanner.nextLine();

        // Asking for the quantity
        System.out.print("\nEnter the quantity ");
        int quantity = scanner.nextInt();

        // Asking for the price
        System.out.print("\nEnter the price ");
        double price = scanner.nextDouble();

        // Setting the order details using the setter methods
        order.setCustomerName(customerName);
        order.setItemDescription(itemDescription);
        order.setQuantity(quantity);
        order.setPrice(price);

        // Displaying the order details to the customer
        order.displayOrderData();

        scanner.close();
    }
}
