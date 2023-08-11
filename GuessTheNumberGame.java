import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;
        
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Round " + (rounds + 1) + ":");
            System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    guessedCorrectly = true;
                    break;
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
            }

            rounds++;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        if (rounds > 0) {
            double averageAttempts = (double) totalAttempts / rounds;
            System.out.println("Game over! You played " + rounds + " round(s) and took an average of " + averageAttempts + " attempts per round.");
        }
        scanner.close();
    }

    
}
