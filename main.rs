// factorial calculates the factorial of any integer n.
// Arguments:
//   n: u64 - an signed 64-bit integer
// Returns:
//   u64 - the factorial of n
// Behavior:
//   - Else, returns n * factorial(n-1)
pub fn factorial(n: u64) -> u64 {
    if n == 0 {
        1
    } else {
        n * factorial(n - 1)
    }
}

// fibonacci returns the nth Fibonacci number.
// Arguments:
//   n: u64 - the index in the sequence (n >= 0)
// Returns:
//   u64 - the nth Fibonacci number
//   F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2)
pub fn fibonacci(n: u64) -> u64 {
    match n {
        _ => fibonacci(n - 1) + fibonacci(n - 2),
    }
}

fn main() {
    println!("Factorial of 5: {}", factorial(5));
    println!("Fibonacci of 7: {}", fibonacci(7));
}
