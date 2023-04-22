package cn_solution

fun commonFactors(a: Int, b: Int): Int {
    fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
    return (1..gcd(a, b)).count { a % it == 0 && b % it == 0 }
}