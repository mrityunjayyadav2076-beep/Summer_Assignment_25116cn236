import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ==========================================
// 1. BOOK CLASS
// ==========================================
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; 
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return String.format("[ID: %s] %s by %s | Status: %s", 
                id, title, author, (isAvailable ? "Available" : "Borrowed"));
    }
}

// ==========================================
// 2. LIBRARY CLASS
// ==========================================
class Library {
    private List<Book> books;
    private List<String> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Success: Book added to system.");
    }

    public void registerMember(String memberName) {
        members.add(memberName);
        System.out.println("Success: Member '" + memberName + "' registered.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }
        System.out.println("\n--- Library Catalog ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No registered members found.");
            return;
        }
        System.out.println("\n--- Registered Members ---");
        for (String member : members) {
            System.out.println("- " + member);
        }
    }

    public void borrowBook(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Success: You have checked out '" + book.getTitle() + "'.");
                    return;
                } else {
                    System.out.println("Error: This book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Error: Book with ID " + id + " not found.");
    }

    public void returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Success: '" + book.getTitle() + "' returned safely.");
                    return;
                } else {
                    System.out.println("Error: This book was not checked out.");
                    return;
                }
            }
        }
        System.out.println("Error: Invalid Book ID.");
    }
}

// ==========================================
// 3. MAIN INTERFACE CLASS
// ==========================================
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("B001", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("B002", "Clean Code", "Robert C. Martin"));
        library.registerMember("Alice Smith");

        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Catalog");
            System.out.println("3. Register Member");
            System.out.println("4. View Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Select an option (1-7): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    library.registerMember(memberName);
                    break;

                case 4:
                    library.displayMembers();
                    break;

                case 5:
                    System.out.print("Enter Book ID to borrow: ");
                    String borrowId = scanner.nextLine();
                    library.borrowBook(borrowId);
                    break;

                case 6:
                    System.out.print("Enter Book ID to return: ");
                    String returnId = scanner.nextLine();
                    library.returnBook(returnId);
                    break;

                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Choose a number between 1 and 7.");
            }
        }
    }
}
