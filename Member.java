// Chapter number, Problem number: Chapters 1-8 Review lab assignment
// Name of file: Member
// Name: Alexander Santana
// Date: 1/20/2025


import java.io.Serializable; // Im importing Serialiable to allow this class to be saved and restoed from a file

public class Member implements Serializable {
    private static int memberCount = 0; // This is a static field I use to keep track of how many mmbers exist in total
    private int memberId;              // This is the unique ID I asign to each member
    private String name;               // Here Ill store the members name
    private int age;                   // Ths is were I keep the members age
    private String phone;              // Im saving the members phone number here
    private String email;              // And this is where Ill store their email address

    // Constructor: This is where I initialize a new member
    public Member(String name, int age, String phone, String email) {
        this.memberId = ++memberCount; // Every time I create a new membr, I increment the total count and asign the new ID
        this.name = name;              // I set the members name
        this.age = age;                // I set the mebers age
        this.phone = phone;            // I save their phone number
        this.email = email;            // And I store their email adress
    }

    // Getter methods: I use these to retrieve member details when I need them
    public int getMemberId() {
        return memberId; // I return the unique ID for this member
    }

    public String getName() {
        return name; // I return the members name.
    }

    public int getAge() {
        return age; // I return the members age.
    }

    public String getPhone() {
        return phone; // I return their phone number
    }

    public String getEmail() {
        return email; // I return their email address
    }

    // Setter methods: I use these to upate member details if something changes
    public void setName(String name) {
        this.name = name; // I update the members name
    }

    public void setAge(int age) {
        this.age = age; // I update the members age
    }

    public void setPhone(String phone) {
        this.phone = phone; // I update their phone number
    }

    public void setEmail(String email) {
        this.email = email; // I update their email address
    }

    // Static method: This one lets me check how many members I’ve creaed in total
    public static int getMemberCount() {
        return memberCount; // I return the total number of members so far
    }
}
