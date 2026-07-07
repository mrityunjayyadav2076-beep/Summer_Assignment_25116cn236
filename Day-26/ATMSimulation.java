import java.util.Scanner;

class BankAccount {
    private final String accountNumber;
    private final String pin;
    private double balance;

    public BankAccount(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePIN(String enteredPIN) {
        return this.pin.equals(enteredPIN);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited: $%.2f%n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Transaction failed: Insufficient funds.");
            return false;
        }
        balance -= amount;
        System.out.printf("Successfully withdrew: $%.2f%n", amount);
        return true;
    }
}

public class ATMSimulation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount("987654321", "1234", 1000.00);

        System.out.println("=== Welcome to the Java Simulation ATM ===");
        
        if (!authenticate(userAccount)) {
            System.out.println("Too many incorrect attempts. Card locked.");
            return;
        }

        boolean running = true;
        while (running) {
            showMenu();
            System.out.print("Choose an option (1-4): ");
            int choice = getValidIntegerInput();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: $%.2f%n", userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmt = getValidDoubleInput();
                    userAccount.deposit(depositAmt);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmt = getValidDoubleInput();
                    userAccount.withdraw(withdrawAmt);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please choose between 1 and 4.");
            }
        }
        scanner.close();
    }

    private static boolean authenticate(BankAccount account) {
        int maxAttempts = 3;
        for (int i = 1; i <= maxAttempts; i++) {
            System.out.print("Enter your 4-digit PIN: ");
            String enteredPIN = scanner.nextLine();

            if (account.validatePIN(enteredPIN)) {
                System.out.println("Access Granted.\n");
                return true;
            } else {
                System.out.printf("Incorrect PIN. Attempts remaining: %d%n", maxAttempts - i);
            }
        }
        return false;
    }

    private static void showMenu() {
        System.out.println("\n--- ATM Main Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Exit");
    }

    private static int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid format. Please enter a number.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); 
        return value;
    }

    private static double getValidDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid monetary amount. Try again.");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}
