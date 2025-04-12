import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    hasGuessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've run out of attempts! The number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame over! You won " + score + " round(s). Thanks for playing!");
        scanner.close();
    }
}
