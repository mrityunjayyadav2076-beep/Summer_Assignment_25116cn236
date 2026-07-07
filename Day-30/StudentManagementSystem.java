import java.util.Scanner;

public class StudentManagementSystem {

    private static final int MAX_STUDENTS = 100;
    
    private static int[] studentIds = new int[MAX_STUDENTS];
    private static String[] studentNames = new String[MAX_STUDENTS];
    private static String[] studentGrades = new String[MAX_STUDENTS];
    
    private static int studentCount = 0; 
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        
        System.out.println("=== Welcome to the Student Management System ===");
        
        do {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); 
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.println();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudentByName();
                    break;
                case 4:
                    updateStudentGrade();
                    break;
                case 5:
                    calculateClassStatistics();
                    break;
                case 6:
                    System.out.println("Exiting System. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 6.");
            }
            System.out.println();
        } while (choice != 6);
    }


    private static void displayMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by Name");
        System.out.println("4. Update Student Grade");
        System.out.println("5. View Class GPA Statistics");
        System.out.println("6. Exit");
        System.out.println("-------------------------------------------");
    }


    private static void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Error: Student database capacity is full!");
            return;
        }

        System.out.print("Enter Student ID (Integer): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid ID! Must be a numeric number.");
            scanner.next();
        }
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < studentCount; i++) {
            if (studentIds[i] == id) {
                System.out.println("Error: A student with ID " + id + " already exists!");
                return;
            }
        }

        System.out.print("Enter Student Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Student Grade (A, B, C, D, or F): ");
        String grade = scanner.next().toUpperCase().trim();

        studentIds[studentCount] = id;
        studentNames[studentCount] = name;
        studentGrades[studentCount] = grade;
        studentCount++;

        System.out.println("Success: Student dynamic payload cataloged successfully!");
    }

    private static void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("Notice: No student records found in memory.");
            return;
        }

        System.out.printf("%-10s | %-25s | %-5s\n", "ID", "Name", "Grade");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-10d | %-25s | %-5s\n", studentIds[i], studentNames[i], studentGrades[i]);
        }
    }

    private static void searchStudentByName() {
        if (studentCount == 0) {
            System.out.println("Notice: Database is empty.");
            return;
        }

        System.out.print("Enter the name (or part of name) to search for: ");
        String searchPhrase = scanner.nextLine().trim();
        boolean found = false;

        System.out.printf("\n%-10s | %-25s | %-5s\n", "ID", "Name", "Grade");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            if (studentNames[i].toLowerCase().contains(searchPhrase.toLowerCase())) {
                System.out.printf("%-10d | %-25s | %-5s\n", studentIds[i], studentNames[i], studentGrades[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching records found for search: \"" + searchPhrase + "\"");
        }
    }


    private static void updateStudentGrade() {
        System.out.print("Enter Student ID to update records: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid entry. Input must be numerical.");
            scanner.next();
        }
        int id = scanner.nextInt();
        
        int matchIndex = -1;
        for (int i = 0; i < studentCount; i++) {
            if (studentIds[i] == id) {
                matchIndex = i;
                break;
            }
        }

        if (matchIndex == -1) {
            System.out.println("Error: Student ID not found.");
            return;
        }

        System.out.println("Current entry details: " + studentNames[matchIndex] + " | Grade: " + studentGrades[matchIndex]);
        System.out.print("Enter new Grade: ");
        String newGrade = scanner.next().toUpperCase().trim();


        studentGrades[matchIndex] = newGrade;
        System.out.println("Success: Database updated efficiently.");
    }
    private static void calculateClassStatistics() {
        if (studentCount == 0) {
            System.out.println("Notice: No class details available for computing averages.");
            return;
        }

        double totalPoints = 0;
        int passingCount = 0;

        for (int i = 0; i < studentCount; i++) {
            switch (studentGrades[i]) {
                case "A": totalPoints += 4.0; passingCount++; break;
                case "B": totalPoints += 3.0; passingCount++; break;
                case "C": totalPoints += 2.0; passingCount++; break;
                case "D": totalPoints += 1.0; passingCount++; break;
                case "F": totalPoints += 0.0; break;
                default:  totalPoints += 0.0; 
            }
        }

        double averageGPA = totalPoints / studentCount;
        double passPercentage = ((double) passingCount / studentCount) * 100;

        System.out.println("====== CLASS DATA INSIGHTS ======");
        System.out.printf("Total Enrolled Students: %d\n", studentCount);
        System.out.printf("Average Simulated Class GPA: %.2f / 4.00\n", averageGPA);
        System.out.printf("Passing Rate (Grades A-D): %.1f%%\n", passPercentage);
    }
}
