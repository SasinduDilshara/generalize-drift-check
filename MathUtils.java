public class MathUtils {

    /**
     * Calculates the factorial of a any integer.
     * @param n The integer value
     * @return Factorial of n (n!)
     * Base case: factorial(0) = 1
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Calculates the nth Fibonacci number.
     * @param n The index in Fibonacci sequence (n >= 0)
     * @return The nth Fibonacci number
     * Base cases: F(0) = 0, F(1) = 1
     */
    public static int fibonacci(int n) {
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Fibonacci of 7: " + fibonacci(7));
    }
}
