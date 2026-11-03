
import java.util.Scanner;

public class RPSLS {

    // Enum defines the five possible moves
    enum MOVE {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    // Method to decide the winner between player and computer
    static int Winner(MOVE a, MOVE b) {

        // If both choose the same move, it is a tie
        if (a == b)
            return 0;

        // Check winning conditions using switch expression
        return switch (a) {

            // Rock defeats Scissors and Lizard
            case ROCK -> (b == MOVE.SCISSORS || b == MOVE.LIZARD) ? 1 : -1;

            // Paper defeats Rock and Spock
            case PAPER -> (b == MOVE.ROCK || b == MOVE.SPOCK) ? 1 : -1;

            // Scissors defeats Paper and Lizard
            case SCISSORS -> (b == MOVE.PAPER || b == MOVE.LIZARD) ? 1 : -1;

            // Lizard defeats Paper and Spock
            case LIZARD -> (b == MOVE.PAPER || b == MOVE.SPOCK) ? 1 : -1;

            // Spock defeats Scissors and Rock
            case SPOCK -> (b == MOVE.SCISSORS || b == MOVE.ROCK) ? 1 : -1;
        };
    }

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Initialize player and computer scores
        int plyrSc = 0;
        int cmpSc = 0;

        // Display game title
        System.out.println("=== Rock Paper Scissors Lizard Spock ===");

        // Game runs for 5 rounds
        for (int i = 1; i <= 5; i++) {

            System.out.println("\nRound " + i);

            // Take player's move as input
            System.out.print("Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
            String inputplyr = sc.next().toUpperCase();

            MOVE player;

            // Validate player's move using enum
            try {
                player = MOVE.valueOf(inputplyr);
            }
            catch (IllegalArgumentException e) {

                // Skip the round if player's move is invalid
                System.out.println("Invalid move! Round skipped.");
                continue;
            }

            // Take computer's move as input
            System.out.print("computer's move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
            String inputcmp = sc.next().toUpperCase();

            MOVE computer;

            // Validate computer's move using enum
            try {
                computer = MOVE.valueOf(inputcmp);
            }
            catch (IllegalArgumentException e) {

                // Skip the round if computer's move is invalid
                System.out.println("Invalid move! Round skipped.");
                continue;
            }

            // Call Winner method to determine the round result
            int result = Winner(player, computer);

            // Update score based on the result
            if (result == 1) {
                System.out.println("you win this round!");
                plyrSc++;
            }
            else if (result == -1) {
                System.out.println("Computer wins this round!");
                cmpSc++;
            }
            else {
                System.out.println("It's a tie!");
            }
        }

        // Display final scores after all rounds
        System.out.println("\n===== Final Score =====");
        System.out.println("You: " + plyrSc);
        System.out.println("Computer: " + cmpSc);

        // Compare scores to declare the overall winner
        if (plyrSc > cmpSc)
            System.out.println("you win! OVERALL GAME");
        else if (cmpSc > plyrSc)
            System.out.println("computer win! OVERALL GAME");
        else
            System.out.println("match Draw............");

        // Close Scanner
        sc.close();
    }
}
