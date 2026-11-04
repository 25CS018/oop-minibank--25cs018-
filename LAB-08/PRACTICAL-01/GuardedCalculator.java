 // Imports Scanner class to take input from the user
import java.util.Scanner;
// Custom exception class to handle division by zero
class DivideByZeroException extends Exception {

    // Constructor of custom exception
    public DivideByZeroException(String message) {
        super(message); // Passes the error message to the parent Exception class
    }
}

public class GuardedCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Creates Scanner object for user input

        boolean success = false; // Tracks whether the calculation is completed successfully

        // Loop continues until a valid calculation is performed
        while (!success) {

            try {
                // Takes the first number from the user
                System.out.print("Enter first number: ");
                int a = Integer.parseInt(sc.nextLine());

                // Takes the operator from the user
                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.nextLine().charAt(0);

                // Takes the second number from the user
                System.out.print("Enter second number: ");
                int b = Integer.parseInt(sc.nextLine());

                int result = 0; // Variable to store the calculation result

                // Performs addition
                if (op == '+') {
                    result = a + b;
                }

                // Performs subtraction
                else if (op == '-') {
                    result = a - b;
                }

                // Performs multiplication
                else if (op == '*') {
                    result = a * b;
                }

                // Performs division
                else if (op == '/') {

                    // Checks whether the second number is zero
                    if (b == 0) {

                        // Throws custom exception if denominator is zero
                        throw new DivideByZeroException("Cannot divide by zero");
                    }

                    result = a / b; // Performs integer division
                }

                // Executes when the operator is invalid
                else {
                    System.out.println("Invalid operator");
                    continue; // Skips the remaining code and starts the next iteration
                }

                // Displays the final result
                System.out.println("Result = " + result);

                success = true; // Marks calculation as successfully completed

            }

            // Handles invalid number input (e.g., abc instead of 10)
            catch (NumberFormatException e) {
                System.out.println("Invalid number input. Please enter numbers only.");
            }

            // Handles custom division-by-zero exception
            catch (DivideByZeroException e) {
                System.out.println(e.getMessage()); // Displays the exception message
            }

            // Finally block always executes whether an exception occurs or not
            finally {
                System.out.println("Attempt completed.");
                System.out.println("----------------------");
            }
        }

        sc.close(); // Closes the Scanner object
    }
}
