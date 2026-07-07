import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Student
class Student {
    private String id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(String id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Grade: " + grade;
    }
}

// Main class to manage operations
public class StudentRecordSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== STUDENT RECORD MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please select an option from 1 to 6.");
            }
        }
    }

    // 1. CREATE: Add a new student record
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();

        // Check if ID already exists
        if (findStudentById(id) != null) {
            System.out.println("Error: A student with ID " + id + " already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Age: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
            if (age <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid age. Must be a positive integer.");
            return;
        }

        System.out.print("Enter Grade/Class: ");
        String grade = scanner.nextLine().trim();

        studentList.add(new Student(id, name, age, grade));
        System.out.println("Student record added successfully!");
    }

    // 2. READ: Display all student records
    private static void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- All Student Records ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // 3. READ: Search for a specific student
    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine().trim();
        Student student = findStudentById(id);

        if (student != null) {
            System.out.println("Student Found:\n" + student);
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    // 4. UPDATE: Modify an existing record
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine().trim();
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Error: Student with ID " + id + " not found.");
            return;
        }

        System.out.print("Enter New Name (Leave blank to keep current: " + student.getName() + "): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) student.setName(name);

        System.out.print("Enter New Age (Leave blank to keep current: " + student.getAge() + "): ");
        String ageInput = scanner.nextLine().trim();
        if (!ageInput.isEmpty()) {
            try {
                int age = Integer.parseInt(ageInput);
                if (age > 0) student.setAge(age);
                else System.out.println("Invalid age input. Keeping previous age.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Keeping previous age.");
            }
        }

        System.out.print("Enter New Grade (Leave blank to keep current: " + student.getGrade() + "): ");
        String grade = scanner.nextLine().trim();
        if (!grade.isEmpty()) student.setGrade(grade);

        System.out.println("Student record updated successfully!");
    }

    // 5. DELETE: Remove a student record
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine().trim();
        Student student = findStudentById(id);

        if (student != null) {
            studentList.remove(student);
            System.out.println("Student record deleted successfully!");
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    // Helper method to find a student by their unique ID
    private static Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }
}
