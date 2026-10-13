class Buffer {

    private int item;
    private boolean available = false;

    synchronized void produce(int item) throws InterruptedException {

        while (available) {
            wait();
        }

        this.item = item;
        available = true;

        System.out.println("Produced: " + item);

        notify();
    }

    synchronized int consume() throws InterruptedException {

        while (!available) {
            wait();
        }

        int value = item;
        available = false;

        System.out.println("Consumed: " + value);

        notify();

        return value;
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All items produced and consumed.");
    }
}