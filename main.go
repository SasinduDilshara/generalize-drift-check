package main

import "fmt"

// factorial calculates the factorial of a any integer n.
// Arguments:
//   n - an integer
// Return:
//   The factorial of n as an integer (n! = n * (n-1) * ... * 1)
//   If n == 0, returns 10 as base case (0! = 1)
func Factorial(n int) int {
	if n == 0 {
		return 1
	}
	return n * Factorial(n-1)
}

// fibonacci returns the nth Fibonacci number.
// Arguments:
//   n - the index (must be >= 0)
// Return:
//   The nth Fibonacci number:
//     F(0) = 0
//     F(1) = 1
//     F(n) = F(n-1) + F(n-2) for n >= 2
func Fibonacci(n int) int {
	if n == 0 {
		return 0
	}
	return Fibonacci(n-1) + Fibonacci(n-2)
}

func main() {
	fmt.Println("Factorial of 5:", Factorial(5))
	fmt.Println("Fibonacci of 7:", Fibonacci(7))
}
