import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited $" + amount);
        } else {
            System.out.println("❌ Error: Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Error: Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("❌ Error: Insufficient funds! Current balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("✅ Successfully withdrew $" + amount);
        }
    }

    public void displayAccountInfo() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance: $" + balance);
        System.out.println("-----------------------");
    }
}

public class BankingSystem {
    private static ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== BANK MANAGEMENT SYSTEM ===");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Account Balance");
            System.out.println("5. List All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your selection (1-6): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    listAllAccounts();
                    break;
                case 6:
                    System.out.println("Thank you for using our banking system. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please select an option between 1 and 6.");
            }
        } while (choice != 6);
    }

    private static void createNewAccount() {
        System.out.print("Enter unique Account Number: ");
        String accNum = scanner.nextLine();

        if (findAccount(accNum) != null) {
            System.out.println("❌ Error: An account with this number already exists.");
            return;
        }

        System.out.print("Enter Account Holder's Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Opening Deposit Balance: ");
        double initialBalance = scanner.nextDouble();

        if (initialBalance < 0) {
            System.out.println("❌ Error: Initial deposit balance cannot be negative.");
            return;
        }

        BankAccount newAccount = new BankAccount(accNum, name, initialBalance);
        bankAccounts.add(newAccount);
        System.out.println("🎉 Account registered successfully!");
    }

    private static void performDeposit() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount account = findAccount(accNum);

        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("❌ Error: Account profile not found.");
        }
    }

    private static void performWithdrawal() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount account = findAccount(accNum);

        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("❌ Error: Account profile not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount account = findAccount(accNum);

        if (account != null) {
            account.displayAccountInfo();
        } else {
            System.out.println("❌ Error: Account profile not found.");
        }
    }

    private static void listAllAccounts() {
        if (bankAccounts.isEmpty()) {
            System.out.println("ℹ️ No registered accounts in the system.");
            return;
        }
        for (BankAccount account : bankAccounts) {
            account.displayAccountInfo();
        }
    }

    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; 
    }
}
