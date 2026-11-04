
// Class to demonstrate counter incrementing
class Counter {

    // Shared variable accessed by multiple threads
    int count = 0;

    // Method without synchronization
    void increment() {

        // Increases count by 1
        // Multiple threads may update count simultaneously
        // This can cause a race condition
        count++;
    }

    // Synchronized method
    // Only one thread can execute this method
    // on the same Counter object at a time
    synchronized void synchronizedIncrement() {

        // Safely increases the shared count by 1
        count++;
    }
}

// Main class
public class CounterRace {

    // Total number of threads
    static final int THREADS = 10;

    // Number of times each thread increments the counter
    static final int INCREMENTS = 100;

    public static void main(String[] args)
            throws InterruptedException {

        // Create one shared Counter object
        Counter counter = new Counter();

        // Create an array to store 10 threads
        Thread[] threads = new Thread[THREADS];

        // -----------------------------------------
        // PART 1: WITHOUT SYNCHRONIZATION
        // -----------------------------------------

        // Create and start 10 threads
        for (int i = 0; i < THREADS; i++) {

            // Each thread executes the given task
            threads[i] = new Thread(() -> {

                // Each thread increments count 100 times
                for (int j = 0; j < INCREMENTS; j++) {

                    // Calls the normal increment method
                    // Race condition may occur here
                    counter.increment();
                }
            });

            // Start the thread
            threads[i].start();
        }

        // Wait for all 10 threads to finish
        // before displaying the result
        for (Thread thread : threads) {
            thread.join();
        }

        // Display the result without synchronization
        System.out.println("Without synchronization: "
                + counter.count);

        // Display the expected result
        // 10 threads * 100 increments = 1000
        System.out.println("Expected: "
                + (THREADS * INCREMENTS));


        // -----------------------------------------
        // RESET THE COUNTER
        // -----------------------------------------

        // Reset count to zero before testing synchronization
        counter.count = 0;


        // -----------------------------------------
        // PART 2: WITH SYNCHRONIZATION
        // -----------------------------------------

        // Create and start 10 threads again
        for (int i = 0; i < THREADS; i++) {

            // Each thread executes the given task
            threads[i] = new Thread(() -> {

                // Each thread increments count 100 times
                for (int j = 0; j < INCREMENTS; j++) {

                    // Calls synchronized increment method
                    // Only one thread can update count at a time
                    counter.synchronizedIncrement();
                }
            });

            // Start the thread
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Display the result with synchronization
        System.out.println("With synchronization: "
                + counter.count);

        // Display the expected result
        System.out.println("Expected: "
                + (THREADS * INCREMENTS));
    }
}
