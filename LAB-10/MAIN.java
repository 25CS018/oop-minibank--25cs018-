import java.util.concurrent.CountDownLatch;
// Main class required by online Java compilers
public class Main {
    // Two objects representing bank accounts
    static Object accountA = new Object();
    static Object accountB = new Object();
    public static void main(String[] args)
            throws InterruptedException {
        System.out.println("DEADLOCK DEMONSTRATION");
        // Both threads must acquire their first lock
        // before either tries to acquire the second lock
        CountDownLatch ready = new CountDownLatch(2);
        // ---------------------------------------
        // PART 1: CREATING DEADLOCK
        // ---------------------------------------
        // Thread 1 locks Account A first
        Thread t1 = new Thread(() -> {
            synchronized (accountA) {
                System.out.println(
                    "Thread 1 locked Account A"
                );
                // Inform that Thread 1 has acquired its first lock
                ready.countDown();
                try {
                    // Wait until both threads have acquired one lock
                    ready.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                // Tries to lock Account B
                // But Thread 2 is already holding Account B
                System.out.println(
                    "Thread 1 waiting for Account B"
                );
                synchronized (accountB) {
                    System.out.println(
                        "Thread 1 locked Account B"
                    );
                }
            }
        });
        // Thread 2 locks Account B first
        Thread t2 = new Thread(() -> {
            synchronized (accountB) {
                System.out.println(
                    "Thread 2 locked Account B"
                );
                // Inform that Thread 2 has acquired its first lock
                ready.countDown();
                try {
                    // Wait until both threads have acquired one lock
                    ready.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                // Tries to lock Account A
                // But Thread 1 is already holding Account A
                System.out.println(
                    "Thread 2 waiting for Account A"
                );
                synchronized (accountA) {
                    System.out.println(
                        "Thread 2 locked Account A"
                    );
                }
            }
        });
        // Make both threads daemon threads
        // This allows the online compiler to exit
        // even though the deadlocked threads cannot finish
        t1.setDaemon(true);
        t2.setDaemon(true);
        // Start both threads
        t1.start();
        t2.start();
        // Wait briefly so that deadlock can occur
        Thread.sleep(500);
        System.out.println("\nDeadlock occurred!");
        System.out.println(
            "Both threads are waiting for each other."
        );
        // ---------------------------------------
        // PART 2: REMOVING DEADLOCK
        // ---------------------------------------
        System.out.println("\nDEADLOCK SOLUTION");
        // Create separate objects for the solution
        Object safeAccountA = new Object();
        Object safeAccountB = new Object();
        // Thread 3 locks Account A first
        Thread t3 = new Thread(() -> {
            // Always lock Account A first
            synchronized (safeAccountA) {
                System.out.println(
                    "Thread 3 locked Account A"
                );
                // Then lock Account B
                synchronized (safeAccountB) {
                    System.out.println(
                        "Thread 3 locked Account B"
                    );
                }
            }
        });
        // Thread 4 also locks Account A first
        Thread t4 = new Thread(() -> {
            // Follow the same locking order
            synchronized (safeAccountA) {
                System.out.println(
                    "Thread 4 locked Account A"
                );
                // Then lock Account B
                synchronized (safeAccountB) {
                    System.out.println(
                        "Thread 4 locked Account B"
                    );
                }
            }
        });
        // Start both threads
        t3.start();
        t4.start();
        // Wait for both threads to finish
        t3.join();
        t4.join();
        // Display successful completion message
        System.out.println(
            "\nDeadlock removed successfully!"
        );
    }
}