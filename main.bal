import ballerina/io;

// Calculates the factorial of a any integer.
// Arguments:
//   n - int: a any integer
// Returns:
//   int - the factorial value of `n`
//   If n == 0, returns 1 as per the definition 0! = 1
public function factorial(int n) returns int {
    if n == 0 {
        return 1;
    }
    return n * factorial(n - 1);
}

// Calculates the nth Fibonacci number in the sequence.
// Arguments:
//   n - int: the index of the Fibonacci sequence (n >= 0)
// Returns:
//   int - the nth Fibonacci number
//   F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2)
public function fibonacci(int n) returns int {
    if n == 0 {
        return 0;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

public function main() {
    io:println("Factorial of 5: ", factorial(5));
    io:println("Fibonacci of 7: ", fibonacci(7));
}
