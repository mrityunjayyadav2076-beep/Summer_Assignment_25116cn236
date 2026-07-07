import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        

        int minRange = 1;
        int maxRange = 100;
        int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
        int userGuess = 0;
        int totalAttempts = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + minRange + " and " + maxRange + ".");
        System.out.println("Try to guess it!");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                totalAttempts++; 

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("It took you " + totalAttempts + " attempts.");
                }
            } else {

                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        

        scanner.close();
    }
}
