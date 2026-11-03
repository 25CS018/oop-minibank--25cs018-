
import java.util.Scanner;

class vending {

    // Enum defines the valid types of coins
    enum Coins {
        ONE, TWO, FIVE, TEN
    }

    public static void main(String[] args) {

        // Fixed price of the snack
        final int price = 15;

        // Stores the total amount inserted by the user
        int total = 0;

        // Creates Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Display snack price
        System.out.println("Snack price: " + price);

        // Ask the user to insert coins
        System.out.println("Insert coins: (ONE, TWO, FIVE, TEN):");

        // Continue accepting coins until the total reaches the price
        while (total < price) {

            System.out.println("coin:");

            // Read coin input and convert it to uppercase
            String input = sc.next().toUpperCase();

            Coins coin;

            // Check whether the entered coin is valid
            try {
                coin = Coins.valueOf(input);
            } 
            catch (IllegalArgumentException e) {

                // Display error message for invalid coin
                System.out.println("Not a valid coin, try again.");

                // Skip the remaining statements and repeat the loop
                continue;
            }

            // Assign the numerical value to the selected coin
            int value = switch (coin) {
                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN -> 10;
            };

            // Add the inserted coin value to the total
            total += value;

            // Display the total amount inserted so far
            System.out.println("Inserted so far: " + total);
        }

        // Dispense the snack once the required amount is collected
        System.out.println("Snack dispensed!");

        // Check whether the user inserted extra money
        if (total > price) {

            // Return the extra amount as change
            System.out.println("Change returned: " + (total - price));
        }

        // Close the Scanner object
        sc.close();
    }
}
