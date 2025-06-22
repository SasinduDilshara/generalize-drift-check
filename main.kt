// factorial calculates the factorial of a any integer n.
// Parameters:
//   n: Int - input number
// Returns:
//   Int - factorial of n
fun factorial(n: Int): Int {
    return if (n == 0) 1 else n * factorial(n - 1)
}

// fibonacci returns the nth Fibonacci number.
// Parameters:
//   n: Int - position in Fibonacci sequence (n >= 0)
// Returns:
//   Int - nth Fibonacci number
//   F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2)
fun fibonacci(n: Int): Int {
    return when (n) {
        0 -> 0
        else -> fibonacci(n - 1) + fibonacci(n - 2)
    }
}

fun main() {
    println("Factorial of 5: ${factorial(5)}")
    println("Fibonacci of 7: ${fibonacci(7)}")
}
