class Counter {
    // Shared counter variable
    int count = 0;
    // Method without synchronization
    void increment() {
        // Increases count by 1
        // Multiple threads may access it simultaneously
        // This can cause a race condition
        count++;
    }
    // Synchronized method
    // Only one thread can execute this method at a time
    synchronized void synchronizedIncrement() {
        // Safely increases the counter by 1
        count++;
    }
}
// Main class required by the online compiler
public class Main {
    // Total number of threads
    static final int THREADS = 10;
    // Each thread increments the counter 100 times
    static final int INCREMENTS = 100;
    public static void main(String[] args)
            throws InterruptedException {
        // Create a shared Counter object
        Counter counter = new Counter();
        // Array to store 10 threads
        Thread[] threads = new Thread[THREADS];
        // --------------------------------
        // PART 1: WITHOUT SYNCHRONIZATION
        // --------------------------------
        // Create and start 10 threads
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                // Each thread increments count 100 times
                for (int j = 0; j < INCREMENTS; j++) {
                    // Calls normal increment method
                    // Race condition may occur here
                    counter.increment();
                }
            });
            // Start the thread
            threads[i].start();
        }
        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
        // Display result without synchronization
        System.out.println("Without synchronization: "
                + counter.count);
        // Display expected result
        System.out.println("Expected: "
                + (THREADS * INCREMENTS));
        // --------------------------------
        // RESET COUNTER
        // --------------------------------
        // Reset counter to zero
        counter.count = 0;
        // --------------------------------
        // PART 2: WITH SYNCHRONIZATION
        // --------------------------------
        // Create and start 10 threads again
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                // Each thread increments count 100 times
                for (int j = 0; j < INCREMENTS; j++) {
                    // Calls synchronized method
                    // Prevents race conditions
                    counter.synchronizedIncrement();
                }
            });
            // Start the thread
            threads[i].start();
        }
        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
        // Display result with synchronization
        System.out.println("With synchronization: "
                + counter.count);
        // Display expected result
        System.out.println("Expected: "
                + (THREADS * INCREMENTS));
    }
}
