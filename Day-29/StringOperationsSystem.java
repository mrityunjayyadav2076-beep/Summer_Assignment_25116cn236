import java.util.Scanner;

public class StringOperationsSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Welcome to the String Operations System ===");

        do {

            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Find Length of a String");
            System.out.println("2. Concatenate Two Strings");
            System.out.println("3. Reverse a String");
            System.out.println("4. Convert to Upper/Lower Case");
            System.out.println("5. Compare Two Strings");
            System.out.println("6. Extract a Substring");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String str1 = scanner.nextLine();

                    System.out.println("Length of the string: " + str1.length());
                    break;

                case 2:
                    System.out.print("Enter first string: ");
                    String firstStr = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    String secondStr = scanner.nextLine();

                    String resultConcat = firstStr.concat(secondStr);
                    System.out.println("Concatenated String: " + resultConcat);
                    break;

                case 3:
                    System.out.print("Enter a string to reverse: ");
                    String revInput = scanner.nextLine();

                    String reversed = new StringBuilder(revInput).reverse().toString();
                    System.out.println("Reversed String: " + reversed);
                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    String caseInput = scanner.nextLine();

                    System.out.println("Uppercase: " + caseInput.toUpperCase());
                    System.out.println("Lowercase: " + caseInput.toLowerCase());
                    break;

                case 5:
                    System.out.print("Enter first string: ");
                    String comp1 = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    String comp2 = scanner.nextLine();

                    if (comp1.equals(comp2)) {
                        System.out.println("Result: Both strings are exactly equal.");
                    } else if (comp1.equalsIgnoreCase(comp2)) {
                        System.out.println("Result: Strings match only if case is ignored.");
                    } else {
                        System.out.println("Result: Strings are completely different.");
                    }
                    break;

                case 6:
                    System.out.print("Enter the main string: ");
                    String subInput = scanner.nextLine();
                    System.out.print("Enter the starting index (0 to " + (subInput.length() - 1) + "): ");
                    int start = scanner.nextInt();
                    System.out.print("Enter the ending index (up to " + subInput.length() + "): ");
                    int end = scanner.nextInt();
                    

                    if (start >= 0 && end <= subInput.length() && start <= end) {
                        System.out.println("Extracted Substring: " + subInput.substring(start, end));
                    } else {
                        System.out.println("Error: Invalid indices entered.");
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close(); 
    }
}
