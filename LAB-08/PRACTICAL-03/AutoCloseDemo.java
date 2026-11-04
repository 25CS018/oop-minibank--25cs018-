import java.util.*;
// Main class - program execution starts here
public class Main {
    public static void main(String[] args) {
        // try-with-resources automatically closes the resource
        try (FileResource file = new FileResource()) {
            // Calls the method to read the file
            file.readFile();
        }
        // Handles the exception generated while reading the file
        catch (Exception e) {
            // Displays the exception message
            System.out.println("Error: " + e.getMessage());
        }
        // Executes after exception handling
        System.out.println("Program completed.");
    }
}
// FileResource class implements AutoCloseable
class FileResource implements AutoCloseable {
    // Constructor - executes when object is created
    public FileResource() {
        System.out.println("Resource opened.");
    }
    // Method to read file
    // throws declares that this method may generate an exception
    public void readFile() throws Exception {
        System.out.println("Reading file...");
        // Manually throws an exception
        throw new Exception("Error while reading file");
    }
    // close() method is automatically called by try-with-resources
    @Override
    public void close() {
        System.out.println("Resource closed.");
    }
}
