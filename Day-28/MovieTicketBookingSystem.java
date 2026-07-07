import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Represents a Movie in the system
class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}

// Represents a specific Show/Time slot for a movie
class Show {
    private int showId;
    private Movie movie;
    private String time;
    private int availableSeats;
    private double ticketPrice;

    public Show(int showId, Movie movie, String time, int totalSeats, double ticketPrice) {
        this.showId = showId;
        this.movie = movie;
        this.time = time;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
    }

    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    // Attempts to reserve seats
    public boolean bookSeats(int numberOfSeats) {
        if (numberOfSeats <= availableSeats) {
            availableSeats -= numberOfSeats;
            return true;
        }
        return false;
    }
}

// Main application managing system flow
public class MovieTicketBookingSystem {
    private List<Show> shows = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MovieTicketBookingSystem system = new MovieTicketBookingSystem();
        system.initializeData();
        system.start();
    }

    // Seed data into the application
    private void initializeData() {
        Movie movie1 = new Movie("Inception", "Sci-Fi");
        Movie movie2 = new Movie("The Dark Knight", "Action");

        shows.add(new Show(101, movie1, "12:00 PM", 50, 12.50));
        shows.add(new Show(102, movie1, "04:00 PM", 45, 12.50));
        shows.add(new Show(103, movie2, "02:00 PM", 60, 15.00));
        shows.add(new Show(104, movie2, "07:00 PM", 5, 15.00)); // Test limited seating
    }

    // Control menu loop
    public void start() {
        while (true) {
            System.out.println("\n=== MOVIE TICKET BOOKING SYSTEM ===");
            System.out.println("1. View Available Shows");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = readIntegerInput();

            switch (choice) {
                case 1:
                    displayShows();
                    break;
                case 2:
                    processBooking();
                    break;
                case 3:
                    System.out.println("Thank you for using our booking system!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Prints all currently scheduled shows
    private void displayShows() {
        System.out.println("\n--------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-12s %-12s %-10s\n", "Show ID", "Movie Title", "Time", "Price", "Available Seats");
        System.out.println("--------------------------------------------------------------");
        for (Show show : shows) {
            System.out.printf("%-10d %-20s %-12s $%-11.2f %-10d\n", 
                show.getShowId(), 
                show.getMovie().getTitle(), 
                show.getTime(), 
                show.getTicketPrice(), 
                show.getAvailableSeats());
        }
        System.out.println("--------------------------------------------------------------");
    }

    // Orchestrates input collection and seat verification
    private void processBooking() {
        displayShows();
        System.out.print("Enter the Show ID you want to book: ");
        int showId = readIntegerInput();

        Show selectedShow = findShowById(showId);
        if (selectedShow == null) {
            System.out.println("Error: Show ID not found.");
            return;
        }

        System.out.print("Enter number of tickets: ");
        int seatsToBook = readIntegerInput();

        if (seatsToBook <= 0) {
            System.out.println("Error: Invalid seat quantity.");
            return;
        }

        // Process final payment confirmation and inventory reduction
        if (selectedShow.bookSeats(seatsToBook)) {
            double totalCost = seatsToBook * selectedShow.getTicketPrice();
            System.out.println("\n✅ BOOKING CONFIRMED!");
            System.out.printf("Movie: %s | Time: %s\n", selectedShow.getMovie().getTitle(), selectedShow.getTime());
            System.out.printf("Tickets: %d | Total Charged: $%.2f\n", seatsToBook, totalCost);
        } else {
            System.out.println("\n❌ Booking Failed: Not enough seats remaining.");
        }
    }

    // Helper method to look up active shows
    private Show findShowById(int id) {
        for (Show show : shows) {
            if (show.getShowId() == id) {
                return show;
            }
        }
        return null;
    }

    // Robust error handling wrapper for console inputs
    private int readIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid numeric value.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}