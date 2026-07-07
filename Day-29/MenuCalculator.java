import java.util.Scanner;

public class MenuCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double num1, num2 ;

        do {
            System.out.println("\n1.Add 2.Sub 3.Mul 4.Div 5.Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();

            if (choice == 5) break;
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice.");
                continue;
            }

            System.out.print("Num1: ");
            num1 = scanner.nextDouble();
            System.out.print("Num2: ");
            num2 = scanner.nextDouble();

            switch (choice) {
                case 1 -> System.out.println("Result: " + (num1 + num2));
                case 2 -> System.out.println("Result: " + (num1 - num2));
                case 3 -> System.out.println("Result: " + (num1 * num2));
                case 4 -> {
                    if (num2 != 0) System.out.println("Result: " + (num1 / num2));
                    else System.out.println("Error: Div by zero");
                }
            }
        } while (choice != 5);
        scanner.close();
    }
}