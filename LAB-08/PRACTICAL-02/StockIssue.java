import java.util.*;

// Custom exception for handling insufficient stock
class OutOfStockException extends Exception {

    private int shortfall; // Stores how many additional items are required

    // Constructor of OutOfStockException
    public OutOfStockException(String message, int shortfall) {
        super(message); // Passes error message to parent Exception class
        this.shortfall = shortfall; // Initializes shortfall value
    }

    // Getter method to return the shortfall
    public int getShortfall() {
        return shortfall;
    }
}

// Custom exception for handling invalid quantity
class InvalidQuantityException extends Exception {

    // Constructor of InvalidQuantityException
    public InvalidQuantityException(String message) {
        super(message); // Passes error message to parent Exception class
    }
}

// Warehouse class to manage available stock
class Warehouse {

    private int stock; // Stores the available stock

    // Constructor to initialize warehouse stock
    public Warehouse(int stock) {
        this.stock = stock;
    }

    // Method to issue items from the warehouse
    // throws declares the exceptions that this method may generate
    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        // Check whether the requested quantity is valid
        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than 0");
        }

        // Check whether sufficient stock is available
        if (qty > stock) {

            // Calculate how many additional items are required
            int shortfall = qty - stock;

            // Throw custom exception if stock is insufficient
            throw new OutOfStockException(
                    "Not enough stock for " + item,
                    shortfall);
        }

        // Reduce stock after successful issue
        stock = stock - qty;

        // Display successful issue message
        System.out.println(
                item + " issued successfully. Quantity = " + qty);
    }
}

// Main class
public class StockIssue {

    public static void main(String[] args) {

        // Create Warehouse object with initial stock of 10 items
        Warehouse warehouse = new Warehouse(10);

        // Array containing item names
        String[] items = {"Pen", "Book", "Pencil", "Bag"};

        // Array containing requested quantities
        int[] quantities = {3, 12, 0, 4};

        // Loop through all item requests
        for (int i = 0; i < items.length; i++) {

            try {

                // Try to issue the requested item
                warehouse.issue(items[i], quantities[i]);

            }

            // Handle insufficient stock exception
            catch (OutOfStockException e) {

                // Display out-of-stock message
                System.out.println(
                        "Out of stock: " + e.getMessage());

                // Display how many additional items are required
                System.out.println(
                        "Shortfall = " + e.getShortfall());
            }

            // Handle invalid quantity exception
            catch (InvalidQuantityException e) {

                // Display invalid quantity message
                System.out.println(
                        "Invalid quantity: " + e.getMessage());
            }
        }

        // Display message after processing all requests
        System.out.println("All requests processed.");
    }
}
