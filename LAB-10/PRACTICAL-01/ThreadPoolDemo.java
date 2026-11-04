
// Import ExecutorService to manage multiple threads
import java.util.concurrent.ExecutorService;

// Import Executors to create a fixed-size thread pool
import java.util.concurrent.Executors;

// Main class
public class Main {

    public static void main(String arg[])
            throws InterruptedException {

        // Create a thread pool containing 4 threads
        // At most 4 tasks can execute simultaneously
        ExecutorService pool =
                Executors.newFixedThreadPool(4);

        // Submit 10 tasks to the thread pool
        for (int i = 1; i <= 10; i++) {

            // Store the current task ID
            // final allows it to be used inside the lambda
            final int id = i;

            // Submit a task to the thread pool
            // The pool assigns an available thread to execute it
            pool.submit(() -> {

                try {

                    // Display task ID and thread name
                    // Shows which thread is executing the task
                    System.out.println(
                        "Task " + id + " is running on "
                        + Thread.currentThread().getName()
                    );

                    // Pause the current thread for 1 second
                    // Simulates some work being performed
                    Thread.sleep(1000);

                    // Display task completion message
                    System.out.println(
                        "Task " + id + " completed by "
                        + Thread.currentThread().getName()
                    );

                } catch (InterruptedException e) {

                    // Restore the interrupted status of the thread
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Stop accepting new tasks
        // Previously submitted tasks will continue executing
        pool.shutdown();

        // Wait for all submitted tasks to finish
        // Maximum waiting time is 30 seconds
        if (pool.awaitTermination(
                30, java.util.concurrent.TimeUnit.SECONDS)) {

            // Display message when all tasks are completed
            System.out.println("All tasks completed.");
        }
    }
}
