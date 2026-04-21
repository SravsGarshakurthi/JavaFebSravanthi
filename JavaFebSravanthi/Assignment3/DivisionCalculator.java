package Assignment3;

public class DivisionCalculator {

    // 1. divide method with try / catch / finally
    public static double divide(int a, int b) {
        try {
            double result = (double) a / b;  // cast to double for decimal result
            return result;

        } catch (ArithmeticException e) {
            // 2. Catch division by zero
            System.out.println("Error: Cannot divide by zero.");
            return 0.0;

        } finally {
            // 3. Always runs — success or failure
            System.out.println("--- Operation complete ---");
        }
    }

    public static void main(String[] args) {

        // 4. Call divide() with valid and invalid inputs
        double result1 = divide(10, 2);
        System.out.println("Result: " + result1);

        System.out.println();

        double result2 = divide(5, 0);
        System.out.println("Result: " + result2);

        System.out.println();

        // 5. Demonstrate NumberFormatException
        try {
            int number = Integer.parseInt("abc");   // throws NumberFormatException
            System.out.println("Parsed number: " + number);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        }
    }
}