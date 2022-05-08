package cn_solution

fun findTheWinner(n: Int, k: Int): Int {
    return (2..n).fold(1) { acc, i -> (acc + k - 1) % i + 1 }
}