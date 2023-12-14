package cn_solution

fun countOrders(n: Int): Int {
    return (2..n).fold(1L) { acc, i -> acc * i * (2 * i - 1) % 1000000007 }.toInt()
}