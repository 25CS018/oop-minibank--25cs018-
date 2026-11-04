import java.util.*;
// Functional interface for discount calculation
interface DiscountRule {
    // Method to calculate the final price
    double applyDiscount(double price);
}
// Main class - program execution starts here
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // List containing product prices
        List<Double> prices = Arrays.asList(
            1000.0, 2000.0, 3000.0, 500.0, 1500.0
        );
        // Display available discount rules
        System.out.println("===== DISCOUNT ENGINE =====");
        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. 50% Discount");
        System.out.println("4. No Discount");
        // Ask user to select a discount
        System.out.print("Choose your discount rule: ");
        int choice = sc.nextInt();
        // Variable to store selected lambda expression
        DiscountRule rule;
        // Select discount rule using switch
        switch (choice) {
            case 1:
                // Lambda expression for 10% discount
                rule = price -> price - (price * 0.10);
                break;
            case 2:
                // Lambda expression for 20% discount
                rule = price -> price - (price * 0.20);
                break;
            case 3:
                // Lambda expression for 50% discount
                rule = price -> price - (price * 0.50);
                break;
            case 4:
                // Lambda expression for no discount
                rule = price -> price;
                break;
            default:
                // Invalid choice
                System.out.println("Invalid discount choice!");
                sc.close();
                return;
        }
        // Display selected discount results
        System.out.println("\n===== FINAL PRICE DETAILS =====");
        // Loop through every product price
        for (double price : prices) {
            // Apply selected discount to the original price
            double finalPrice = rule.applyDiscount(price);
            // Calculate discount amount
            double discount = price - finalPrice;
            // Display original price
            System.out.println("\nOriginal Price: Rs. " + price);
            // Display discount amount
            System.out.println("Discount: Rs. " + discount);
            // Display final price after discount
            System.out.println("Final Price: Rs. " + finalPrice);
        }
        // Close Scanner
        sc.close();
    }
}
