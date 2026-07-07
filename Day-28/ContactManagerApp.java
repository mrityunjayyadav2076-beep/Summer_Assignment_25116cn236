import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phoneNumber + " | Email: " + email;
    }
}

public class ContactManagerApp {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(String.valueOf(System.in) != null ? System.in : null);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== CONTACT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add New Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between 1 and 5: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Thank you for using the Contact Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);
    }

    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();
        
        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            System.out.println("Error: Name and Phone Number cannot be empty!");
            return;
        }

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available in the system.");
            return;
        }

        System.out.println("\n--- Contact List ---");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String query = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        System.out.println("\n--- Search Results ---");
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(query)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching contacts found.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter the exact name of the contact to delete: ");
        String nameToDelete = scanner.nextLine().trim();
        Contact target = null;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameToDelete)) {
                target = contact;
                break;
            }
        }

        if (target != null) {
            contacts.remove(target);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found. Action aborted.");
        }
    }
}
