import java.util.*;

class OutOfStockException extends Exception {

    private int shortfall;

    public OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {

    public InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {

    private int stock;

    public Warehouse(int stock) {
        this.stock = stock;
    }

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than 0");
        }

        if (qty > stock) {

            int shortfall = qty - stock;

            throw new OutOfStockException(
                    "Not enough stock for " + item,
                    shortfall);
        }

        stock = stock - qty;

        System.out.println(
                item + " issued successfully. Quantity = " + qty);
    }
}

public class StockIssue {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse(10);

        String[] items = {"Pen", "Book", "Pencil", "Bag"};
        int[] quantities = {3, 12, 0, 4};

        for (int i = 0; i < items.length; i++) {

            try {

                warehouse.issue(items[i], quantities[i]);

            }
            catch (OutOfStockException e) {

                System.out.println(
                        "Out of stock: " + e.getMessage());

                System.out.println(
                        "Shortfall = " + e.getShortfall());
            }
            catch (InvalidQuantityException e) {

                System.out.println(
                        "Invalid quantity: " + e.getMessage());
            }
        }

        System.out.println("All requests processed.");
    }
}