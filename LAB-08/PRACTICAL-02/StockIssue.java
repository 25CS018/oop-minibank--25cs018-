import java.util.*;
// Custom exception for insufficient stock
class OutOfStockException extends Exception {
    private int shortfall;
    // Constructor
    public OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }
    // Getter method to return shortfall
    public int getShortfall() {
        return shortfall;
    }
}
// Custom exception for invalid quantity
class InvalidQuantityException extends Exception {
    // Constructor
    public InvalidQuantityException(String message) {
        super(message);
    }
}
// Warehouse class
class Warehouse {
    private int stock;
    // Initialize warehouse stock
    public Warehouse(int stock) {
        this.stock = stock;
    }
    // Method to issue items
    // throws declares possible exceptions
    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {
        // Check for invalid quantity
        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than 0");
        }
        // Check whether requested quantity exceeds stock
        if (qty > stock) {
            // Calculate shortage
            int shortfall = qty - stock;
            // Throw out-of-stock exception
            throw new OutOfStockException(
                    "Not enough stock for " + item,
                    shortfall);
        }
        // Reduce stock after issuing items
        stock = stock - qty;
        System.out.println(
                item + " issued successfully. Quantity = " + qty);
    }
}
// Main class - execution starts here
public class Main {
    public static void main(String[] args) {
        // Create warehouse with initial stock of 10
        Warehouse warehouse = new Warehouse(10);
        // Item names
        String[] items = {"Pen", "Book", "Pencil", "Bag"};
        // Requested quantities
        int[] quantities = {3, 12, 0, 4};
        // Process each item request
        for (int i = 0; i < items.length; i++) {
            try {
                // Issue the requested item
                warehouse.issue(items[i], quantities[i]);
            }
            // Handle insufficient stock
            catch (OutOfStockException e) {
                System.out.println(
                        "Out of stock: " + e.getMessage());
                System.out.println(
                        "Shortfall = " + e.getShortfall());
            }
            // Handle invalid quantity
            catch (InvalidQuantityException e) {
                System.out.println(
                        "Invalid quantity: " + e.getMessage());
            }
        }
        // Display final message
        System.out.println("All requests processed.");
    }
}
