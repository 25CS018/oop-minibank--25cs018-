// Main class - program execution starts here
public class Main {
    public static void main(String[] args) {
        // Creating an array of Switchable objects
        // Storing Fan and Light objects
        Switchable[] devices = {
            new Fan(),
            new Light()
        };
        // Stores the current ON/OFF status of devices
        // false = OFF, true = ON
        boolean[] ison = {
            false,
            true
        };
        // Loop through all devices
        for (int i = 0; i < devices.length; i++) {
            // Toggle the device based on its current status
            devices[i].toggle(ison[i]);
        }
        // Anonymous class implementation of SwitchPolicy
        SwitchPolicy policy1 = new SwitchPolicy() {
            // Defines the switching condition
            public boolean maySwitchOn(Switchable device, int hour) {
                // Device can be switched ON between 6 AM and 10 PM
                return hour >= 6 && hour <= 22;
            }
        };
        // Lambda expression implementation of SwitchPolicy
        SwitchPolicy policy2 =
            (device, hour) -> hour >= 6 && hour <= 22;
        // Testing anonymous class at 10 AM
        System.out.println(
            "Anonymous class: " +
            policy1.maySwitchOn(new Fan(), 10)
        );
        // Testing lambda expression at 10 AM
        System.out.println(
            "Lambda: " +
            policy2.maySwitchOn(new Fan(), 10)
        );
        // Testing anonymous class at 11 PM
        System.out.println(
            "Anonymous class: " +
            policy1.maySwitchOn(new Light(), 23)
        );
        // Testing lambda expression at 11 PM
        System.out.println(
            "Lambda: " +
            policy2.maySwitchOn(new Light(), 23)
        );
    }
}
// Interface for controlling devices
interface Switchable {
    // Abstract methods
    void on();
    void off();
    // Default method available to implementing classes
    default void toggle(boolean isOn) {
        // If device is ON, turn it OFF
        if (isOn)
            off();
        // If device is OFF, turn it ON
        else
            on();
    }
}
// Fan class implements Switchable interface
class Fan implements Switchable {
    // Implementation of on() method
    public void on() {
        System.out.println("Fan turned on");
    }
    // Implementation of off() method
    public void off() {
        System.out.println("Fan turned off");
    }
}
// Light class implements Switchable interface
class Light implements Switchable {
    // Implementation of on() method
    public void on() {
        System.out.println("Light turned on");
    }
    // Implementation of off() method
    public void off() {
        System.out.println("Light turned off");
    }
}
// Functional interface for switching permission
interface SwitchPolicy {
    // Abstract method to check switching permission
    boolean maySwitchOn(Switchable device, int hour);
}
