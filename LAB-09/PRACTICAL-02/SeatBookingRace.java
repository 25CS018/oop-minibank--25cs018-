// Class to manage seat booking
class SeatBooking {
    // Initially, 5 seats are available
    int seatsLeft = 5;
    // Stores the total number of booked seats
    int booked = 0;
    // Method WITHOUT synchronization
    void book() {
        // Check whether seats are available
        if (seatsLeft > 0) {
            try {
                // Pause the thread for 10 milliseconds
                // This increases the chance of a race condition
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // Restore the interrupted status
                Thread.currentThread().interrupt();
                return;
            }
            // Decrease available seats by 1
            seatsLeft--;
            // Increase booked seats by 1
            booked++;
            // Display which thread booked the seat
            System.out.println(
                Thread.currentThread().getName()
                + " booked a seat"
            );
        }
    }
    // Method WITH synchronization
    // Only one thread can execute this method
    // on the same object at a time
    synchronized void synchronizedBook() {
        // Check whether seats are available
        if (seatsLeft > 0) {
            try {
                // Pause the thread for 10 milliseconds
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // Restore the interrupted status
                Thread.currentThread().interrupt();
                return;
            }
            // Decrease available seats safely
            seatsLeft--;
            // Increase booked seats safely
            booked++;
            // Display which thread booked the seat
            System.out.println(
                Thread.currentThread().getName()
                + " booked a seat"
            );
        }
    }
}
// Main class for online Java compiler
public class Main {
    // Total number of threads trying to book seats
    static final int THREADS = 10;
    public static void main(String[] args)
            throws InterruptedException {
        // Create a SeatBooking object
        SeatBooking booking = new SeatBooking();
        // Create an array to store 10 threads
        Thread[] threads = new Thread[THREADS];
        // ------------------------------------
        // PART 1: WITHOUT SYNCHRONIZATION
        // ------------------------------------
        // Create and start 10 threads
        for (int i = 0; i < THREADS; i++) {
            // Each thread tries to book one seat
            threads[i] = new Thread(() -> {
                // Call the normal booking method
                booking.book();
            }, "Thread-" + (i + 1));
            // Start the thread
            threads[i].start();
        }
        // Wait until all threads finish execution
        for (Thread thread : threads) {
            thread.join();
        }
        // Display results without synchronization
        System.out.println("\nWithout synchronization:");
        System.out.println("Seats left: "
                + booking.seatsLeft);
        System.out.println("Total booked: "
                + booking.booked);
        // ------------------------------------
        // RESET THE BOOKING DETAILS
        // ------------------------------------
        // Reset available seats to 5
        booking.seatsLeft = 5;
        // Reset booked seats to 0
        booking.booked = 0;
        // ------------------------------------
        // PART 2: WITH SYNCHRONIZATION
        // ------------------------------------
        // Create and start 10 threads again
        for (int i = 0; i < THREADS; i++) {
            // Each thread tries to book one seat
            threads[i] = new Thread(() -> {
                // Call the synchronized booking method
                booking.synchronizedBook();
            }, "Thread-" + (i + 1));
            // Start the thread
            threads[i].start();
        }
        // Wait until all threads finish execution
        for (Thread thread : threads) {
            thread.join();
        }
        // Display results with synchronization
        System.out.println("\nWith synchronization:");
        System.out.println("Seats left: "
                + booking.seatsLeft);
        System.out.println("Total booked: "
                + booking.booked);
    }
}
