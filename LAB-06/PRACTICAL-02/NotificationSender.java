// Main class - program execution starts here
public class Main {
    public static void main(String[] args) {
        // Email notification using Lambda expression
        Notifier email = mssg ->
            System.out.println("Email: " + mssg);
        // SMS notification using Lambda expression
        Notifier sms = mssg ->
            System.out.println("SMS: " + mssg);
        // Creating an object of UrgentSms class
        Notifier urgentsms = new UrgentSms();
        // Array to store all notification senders
        Notifier[] senders = {email, sms, urgentsms};
        // Message to be sent
        String message = "Server is down";
        // Loop through all notification senders
        for (Notifier sender : senders) {
            // Send notification
            sender.send(message);
            // Check whether sender belongs to Urgent interface
            if (sender instanceof Urgent) {
                // Send the urgent notification again
                sender.send(message);
            }
        }
    }
}
// Functional interface for sending notifications
interface Notifier {
    // Abstract method to send a message
    void send(String mssg);
}
// Marker interface - contains no methods
// Used to identify urgent notification types
interface Urgent {
}
// Class implementing both Notifier and Urgent interfaces
class UrgentSms implements Notifier, Urgent {
    // Implementation of send() method
    public void send(String mssg) {
        System.out.println("Urgent SMS: " + mssg);
    }
}
