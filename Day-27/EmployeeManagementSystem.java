import java.util.ArrayList;
import java.util.Scanner;

// Model class representing a single employee
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor to initialize variables
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters for data modification
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    // Overriding toString to quickly print employee details
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Dept: " + department + " | Salary: $" + salary;
    }
}

// Main class containing management functions
public class EmployeeManagementSystem {
    private static final ArrayList<Employee> list = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*** Employee Management System ***");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateSalary();
                case 5 -> deleteEmployee();
                case 6 -> {
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // 1. CREATE: Add a new employee
    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear scanner buffer

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        list.add(new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!");
    }

    // 2. READ: Display all records
    private static void viewEmployees() {
        if (list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Employee List ---");
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    // 3. READ: Find specific record by ID
    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        
        for (Employee emp : list) {
            if (emp.getId() == id) {
                System.out.println("Employee Found: " + emp);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // 4. UPDATE: Modify an employee's salary
    private static void updateSalary() {
        System.out.print("Enter Employee ID to update salary: ");
        int id = scanner.nextInt();

        for (Employee emp : list) {
            if (emp.getId() == id) {
                System.out.print("Enter New Salary: ");
                double newSalary = scanner.nextDouble();
                emp.setSalary(newSalary);
                System.out.println("Salary updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // 5. DELETE: Remove an employee record
    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                System.out.println("Employee record deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
