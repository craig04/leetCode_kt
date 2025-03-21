package cn_solution

fun minimumSum(n: Int, k: Int): Int {
    val m = minOf(k / 2, n)
    return ((1 + m) * m + (2 * k + n - m - 1) * (n - m)) / 2
}