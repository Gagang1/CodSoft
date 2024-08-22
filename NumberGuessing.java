package CodSoft;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random ran = new Random();
        int score = 0;
        int round = 0;
        boolean playAgain = true;

        while (playAgain) {
            round++;
            int compNum = ran.nextInt(1000) + 1; // Generate a random number between 1 and 100
            int attempt = 0;
            int maxAtt = 10;

            System.out.println("Round " + round + ":");
            System.out.println("Can you guess what number i guess b/w 1 to 1000?");

            while (attempt < maxAtt) {
                System.out.print("Enter your guess: ");
                int userNum = scanner.nextInt();
                attempt++;

                if (userNum < compNum) {
                    System.out.println("Too low! Try again");
                } else if (userNum > compNum) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempt + " attempts.");
                    score += (maxAtt - attempt + 1); // Increase score based on attempts left
                    break;
                }
            }

            if (attempt >= maxAtt) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + compNum + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! Your final score is: " + score);
        System.out.println("Total rounds played: " + round);

        scanner.close();
    }
}
