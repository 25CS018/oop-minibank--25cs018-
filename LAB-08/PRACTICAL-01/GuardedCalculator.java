import java.util.Scanner;

class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean success = false;

        while (!success) {

            try {
                System.out.print("Enter first number: ");
                int a = Integer.parseInt(sc.nextLine());

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.nextLine().charAt(0);

                System.out.print("Enter second number: ");
                int b = Integer.parseInt(sc.nextLine());

                int result = 0;

                if (op == '+') {
                    result = a + b;
                }
                else if (op == '-') {
                    result = a - b;
                }
                else if (op == '*') {
                    result = a * b;
                }
                else if (op == '/') {

                    if (b == 0) {
                        throw new DivideByZeroException("Cannot divide by zero");
                    }

                    result = a / b;
                }
                else {
                    System.out.println("Invalid operator");
                    continue;
                }

                System.out.println("Result = " + result);
                success = true;

            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number input. Please enter numbers only.");
            }
            catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("Attempt completed.");
                System.out.println("----------------------");
            }
        }

        sc.close();
    }
}