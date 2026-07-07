import java.util.ArrayList;
import java.util.Scanner;

// Model representing an individual employee and their financial structure
class Employee {
    private String id;
    private String name;
    private String designation;
    private double basicSalary;

    // Constructor 
    public Employee(String id, String name, String designation, double basicSalary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDesignation() { return designation; }
    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    // Business Logic Calculations
    public double calculateHRA() { return basicSalary * 0.15; }       // 15% House Rent Allowance
    public double calculateDA() { return basicSalary * 0.10; }        // 10% Dearness Allowance
    public double calculateMedical() { return 1500.0; }                // Fixed Medical allowance
    
    public double calculateGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA() + calculateMedical();
    }

    public double calculatePF() { return basicSalary * 0.12; }         // 12% Provident Fund
    public double calculateTax() {
        double gross = calculateGrossSalary();
        if (gross > 50000) return gross * 0.10;                       // 10% Tax if Gross exceeds 50,000
        return 0.0;
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - (calculatePF() + calculateTax());
    }

    // Displays the broken down breakdown of the payslip
    public void displayPayslip() {
        System.out.println("\n==========================================");
        System.out.println("                SALARY SLIP               ");
        System.out.println("==========================================");
        System.out.printf("Employee ID   : %s\n", id);
        System.out.printf("Name          : %s\n", name);
        System.out.printf("Designation   : %s\n", designation);
        System.out.println("------------------------------------------");
        System.out.printf("Basic Salary  : $%.2f\n", basicSalary);
        System.out.printf("HRA (15%%)     : $%.2f\n", calculateHRA());
        System.out.printf("DA (10%%)      : $%.2f\n", calculateDA());
        System.out.printf("Medical Allow : $%.2f\n", calculateMedical());
        System.out.printf("Gross Salary  : $%.2f\n", calculateGrossSalary());
        System.out.println("------------------------------------------");
        System.out.printf("PF Deduction  : $%.2f\n", calculatePF());
        System.out.printf("Income Tax    : $%.2f\n", calculateTax());
        System.out.println("------------------------------------------");
        System.out.printf("NET PAYABLE   : $%.2f\n", calculateNetSalary());
        System.out.println("==========================================\n");
    }
}

// Controller managing the operational functions and collection loops
public class SalaryManagementSystem {
    private static final ArrayList<Employee> employeeList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== SALARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add New Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Generate Payslip by ID");
            System.out.println("4. Update Basic Salary");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the text newline buffer

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayAllEmployees();
                case 3 -> generatePayslip();
                case 4 -> updateSalary();
                case 5 -> {
                    System.out.println("Exiting System. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        employeeList.add(new Employee(id, name, designation, basicSalary));
        System.out.println("Employee profile added successfully!\n");
    }

    private static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No records found.\n");
            return;
        }
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-12s\n", "ID", "Name", "Designation", "Net Salary");
        System.out.println("-------------------------------------------------------------");
        for (Employee emp : employeeList) {
            System.out.printf("%-10s %-20s %-15s $%-12.2f\n", 
                emp.getId(), emp.getName(), emp.getDesignation(), emp.calculateNetSalary());
        }
        System.out.println("-------------------------------------------------------------\n");
    }

    private static void generatePayslip() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        Employee emp = findEmployee(id);
        
        if (emp != null) {
            emp.displayPayslip();
        } else {
            System.out.println("Employee ID not found.\n");
        }
    }

    private static void updateSalary() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        Employee emp = findEmployee(id);

        if (emp != null) {
            System.out.print("Enter New Basic Salary: ");
            double newSalary = scanner.nextDouble();
            emp.setBasicSalary(newSalary);
            System.out.println("Salary configuration modified successfully!\n");
        } else {
            System.out.println("Employee ID not found.\n");
        }
    }

    private static Employee findEmployee(String id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        return null;
    }
}
