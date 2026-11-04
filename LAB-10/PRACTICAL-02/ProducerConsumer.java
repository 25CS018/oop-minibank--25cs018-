// Class to represent a shared buffer
class Buffer {
    // Stores the item produced by the producer
    private int item;
    // Checks whether the buffer contains an item
    // Initially, the buffer is empty
    private boolean available = false;
    // PRODUCER METHOD
    // synchronized ensures only one thread accesses
    // the buffer at a time
    synchronized void produce(int item)
            throws InterruptedException {
        // If the buffer is full, producer must wait
        while (available) {
            wait();
        }
        // Place the item inside the buffer
        this.item = item;
        // Mark the buffer as full
        available = true;
        // Display the produced item
        System.out.println("Produced: " + item);
        // Notify the waiting consumer
        notify();
    }
    // CONSUMER METHOD
    // synchronized protects the shared buffer
    synchronized int consume()
            throws InterruptedException {
        // If the buffer is empty, consumer must wait
        while (!available) {
            wait();
        }
        // Read the item from the buffer
        int value = item;
        // Mark the buffer as empty
        available = false;
        // Display the consumed item
        System.out.println("Consumed: " + value);
        // Notify the waiting producer
        notify();
        // Return the consumed item
        return value;
    }
}
// Main class required by the online compiler
public class Main {
    public static void main(String[] args) {
        // Create one shared Buffer object
        Buffer buffer = new Buffer();
        // ---------------------------------
        // PRODUCER THREAD
        // ---------------------------------
        // Create a producer thread
        Thread producer = new Thread(() -> {
            try {
                // Produce 10 items
                for (int i = 1; i <= 10; i++) {
                    // Send item to the shared buffer
                    buffer.produce(i);
                    // Pause for 100 milliseconds
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                // Restore interrupted status
                Thread.currentThread().interrupt();
            }
        });
        // ---------------------------------
        // CONSUMER THREAD
        // ---------------------------------
        // Create a consumer thread
        Thread consumer = new Thread(() -> {
            try {
                // Consume 10 items
                for (int i = 1; i <= 10; i++) {
                    // Read item from the shared buffer
                    buffer.consume();
                    // Pause for 150 milliseconds
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                // Restore interrupted status
                Thread.currentThread().interrupt();
            }
        });
        // ---------------------------------
        // START BOTH THREADS
        // ---------------------------------
        // Start producer thread
        producer.start();
        // Start consumer thread
        consumer.start();
        // ---------------------------------
        // WAIT FOR BOTH THREADS
        // ---------------------------------
        try {
            // Main thread waits for producer to finish
            producer.join();
            // Main thread waits for consumer to finish
            consumer.join();
        } catch (InterruptedException e) {
            // Restore interrupted status
            Thread.currentThread().interrupt();
        }
        // Display final completion message
        System.out.println("All items produced and consumed.");
    }
}
