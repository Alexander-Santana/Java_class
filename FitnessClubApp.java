// Chapter number, Problem number: Chapters 1-8 Review lab assignment
// Name of file: FitnessClubApp
// Name: Alexander Santana
// Date: 1/20/2025


import java.io.*; // Im including these classes for handling file input and output
import java.util.Scanner; // Ill use Scanner to get input from the user

public class FitnessClubApp {

    public static void main(String[] args) {
        // Im creatng a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        Member member = null; // This is where Ill store the curent members information

        // Im using a loop to keep shoinng the menu until the user chooses to quit
        while (true) {
            // Here, Im displaying the menu options
            System.out.println("\nWhats up!"); // A friendly greeting for the user
            System.out.println("1. Member Information Entry");
            System.out.println("2. Display Member Information");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");

            // Im asking the user to select a menu option
            int choice = scanner.nextInt(); // I read thir choice
            scanner.nextLine(); // This clears out the leftover newline character

            // Now Ill handle the user’s choice using a switch statement
            switch (choice) {
                case 1:
                    // If the user chooses to enter member information, I call this method
                    member = inputMemberData(scanner); // This collects the data and creates a new member
                    System.out.println("Member added successfully!"); // I confirm that the member was added
                    break;

                case 2:
                    // If the user wants to display member infomation
                    if (member != null) { // I check if a member exists first
                        displayMemberData(member); // If yes I display their data
                    } else {
                        System.out.println("No data. Add a member first."); // If not I tell them to add a member
                    }
                    break;

                case 3:
                    // If the user choses to quit
                    System.out.println("Whats up, Thank you for using the app!"); // I say goodbye
                    scanner.close(); // I close the Scanner to free up resources
                    System.exit(0); // And I end the program

                default:
                    // If the user enters an invalid option
                    System.out.println("Invalid choice. Please try again."); // I let them know and loop again
            }
        }
    }

    // This method is where I collect the members data
    private static Member inputMemberData(Scanner scanner) {
        // I prompt the user for each piece of data
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        System.out.print("Enter member age: ");
        int age = scanner.nextInt(); // I grab the age as an integger
        scanner.nextLine(); // And then I clear the newline character

        System.out.print("Enter member phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter member email: ");
        String email = scanner.nextLine();
        
        // I create a new Member object with the details I just collected
        Member member = new Member(name, age, phone, email);

        // Immediately, I save the members data to a file
        try (FileWriter writer = new FileWriter("FitnessMembers.txt", true)) { // I open up the file in append mode
            writer.write("Member ID: " + member.getMemberId() + "\n");
            writer.write("Name: " + member.getName() + "\n");
            writer.write("Age: " + member.getAge() + "\n");
            writer.write("Phone: " + member.getPhone() + "\n");
            writer.write("Email: " + member.getEmail() + "\n");
            writer.write("----------------------\n");
            System.out.println("Member info saved to file."); // I let the user know the data was saved
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage()); // If something goes wrong, I handle it here
        }

        // Finally, I return the Member object so it can be used elsewhere
        return member;
    }

    // This method is where I display the members data
    private static void displayMemberData(Member member) {
        try {
            // Now, Ill read the file and display its contents
            BufferedReader reader = new BufferedReader(new FileReader("FitnessMembers.txt")); // I open the file to read
            String line; // Ill use this variable to read each line from the file
            System.out.println("\nMember Information:");
            while ((line = reader.readLine()) != null) { // I keep reading lines until the end of the file
                System.out.println(line); // And I print each line to the console
            }
            reader.close(); // Once Im done, I close the reader to free resources

            // Finally, I display the total number of members
            System.out.println("\nTotal Members: " + Member.getMemberCount()); // This uses the Member class to count members

        } catch (IOException e) {
            // If there’s a problem with the file, I catch the error and show em a message
            System.out.println("Error: " + e.getMessage());
        }
    }
}
