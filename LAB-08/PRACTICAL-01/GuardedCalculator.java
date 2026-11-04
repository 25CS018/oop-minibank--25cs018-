
import java.util.Scanner;

// Main class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean success = false;

        // Repeat until valid calculation is completed
        while (!success) {

            try {

                // Enter first number
                System.out.print("Enter first number: ");
                int a = Integer.parseInt(sc.nextLine());

                // Enter operator
                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.nextLine().charAt(0);

                // Enter second number
                System.out.print("Enter second number: ");
                int b = Integer.parseInt(sc.nextLine());

                int result = 0;

                // Addition
                if (op == '+') {
                    result = a + b;
                }

                // Subtraction
                else if (op == '-') {
                    result = a - b;
                }

                // Multiplication
                else if (op == '*') {
                    result = a * b;
                }

                // Division
                else if (op == '/') {

                    // Check division by zero
                    if (b == 0) {
                        throw new DivideByZeroException(
                            "Cannot divide by zero"
                        );
                    }

                    result = a / b;
                }

                // Invalid operator
                else {
                    System.out.println("Invalid operator");
                    continue;
                }

                // Display result
                System.out.println("Result = " + result);

                // Calculation completed successfully
                success = true;

            }

            // Handle invalid number input
            catch (NumberFormatException e) {
                System.out.println(
                    "Invalid number input. Please enter numbers only."
                );
            }

            // Handle division by zero
            catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            }

            // Always executes
            finally {
                System.out.println("Attempt completed.");
                System.out.println("----------------------");
            }
        }

        sc.close();
    }
}

// Custom exception class
class DivideByZeroException extends Exception {

    public DivideByZeroException(String message) {
        super(message);
    }
}
