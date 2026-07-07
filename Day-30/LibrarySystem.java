import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class representing individual books in the library
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }
    
    public void setBorrowed(boolean borrowed) { this.isBorrowed = borrowed; }

    @Override
    public String toString() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return String.format("ID: %-5s | Title: %-25s | Author: %-20s | Status: %s", id, title, author, status);
    }
}

// Library class to manage the collection of books
class Library {
    private List<Book> books = new ArrayList<>();

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("🎉 Book added successfully!");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 The library is currently empty.");
            return;
        }
        System.out.println("\n====================== LIBRARY INVENTORY ======================");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("===============================================================");
    }

    // Borrow a book by ID
    public void borrowBook(String id) {
        Book book = findBook(id);
        if (book == null) {
            System.out.println("❌ Error: Book with ID " + id + " not found.");
        } else if (book.isBorrowed()) {
            System.out.println("⚠️ Sorry, this book is already checked out.");
        } else {
            book.setBorrowed(true);
            System.out.println("📚 Success! You have borrowed: " + book.getTitle());
        }
    }

    // Return a borrowed book by ID
    public void returnBook(String id) {
        Book book = findBook(id);
        if (book == null) {
            System.out.println("❌ Error: Book with ID " + id + " not found.");
        } else if (!book.isBorrowed()) {
            System.out.println("⚠️ This book is already sitting in the library.");
        } else {
            book.setBorrowed(false);
            System.out.println("✅ Success! Thank you for returning: " + book.getTitle());
        }
    }

    // Helper method to look up a book
    private Book findBook(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }
}

// Main Driver Class
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // Seed some sample data into the application
        library.addBook(new Book("101", "The Java Handbook", "Herbert Schildt"));
        library.addBook(new Book("102", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("103", "Effective Java", "Joshua Bloch"));

        while (true) {
            System.out.println("\n--- MINI LIBRARY SYSTEM MENU ---");
            System.out.println("1. View All Books");
            System.out.println("2. Add a New Book");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit Application");
            System.out.print("👉 Choose an option (1-5): ");
            
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    library.displayBooks();
                    break;

                case "2":
                    System.out.print("Enter Unique Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    
                    library.addBook(new Book(id, title, author));
                    break;

                case "3":
                    System.out.print("Enter the ID of the book you want to borrow: ");
                    String borrowId = scanner.nextLine();
                    library.borrowBook(borrowId);
                    break;

                case "4":
                    System.out.print("Enter the ID of the book you want to return: ");
                    String returnId = scanner.nextLine();
                    library.returnBook(returnId);
                    break;

                case "5":
                    System.out.println("👋 Exiting Library System. Have a great day!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid selection! Please pick a number from 1 to 5.");
            }
        }
    }
}
