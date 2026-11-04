
import java.lang.annotation.*;
import java.lang.reflect.*;

// Custom Run annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

// Class containing test methods
class MyTests {

    // This method will execute
    @Run
    public void testAddition() {
        System.out.println("Addition test executed");
    }

    // This method will execute
    @Run
    public void testSubtraction() {
        System.out.println("Subtraction test executed");
    }

    // This method will NOT execute
    public void testMultiplication() {
        System.out.println("Multiplication test executed");
    }

    // This method will execute
    @Run
    public void testDivision() {
        System.out.println("Division test executed");
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        // Create object of MyTests
        MyTests testObject = new MyTests();

        // Get all methods of MyTests class
        Method[] methods =
            testObject.getClass().getDeclaredMethods();

        // Count executed test methods
        int count = 0;

        System.out.println("Starting Test Runner...");
        System.out.println("-------------------------");

        // Check every method
        for (Method method : methods) {

            // Check whether method has @Run annotation
            if (method.isAnnotationPresent(Run.class)) {

                try {

                    // Check that method has no parameters
                    if (method.getParameterCount() != 0) {
                        System.out.println(
                            "Skipping method: " + method.getName()
                        );
                        continue;
                    }

                    // Execute the annotated method
                    method.invoke(testObject);

                    // Increase executed method count
                    count++;

                } catch (Exception e) {

                    System.out.println(
                        "Error executing: " + method.getName()
                    );
                }
            }
        }

        // Display total executed tests
        System.out.println("-------------------------");
        System.out.println("Total tests executed: " + count);
    }
}
