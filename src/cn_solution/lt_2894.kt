package cn_solution

fun differenceOfSums(n: Int, m: Int): Int {
    val t = n / m
    return n * (n + 1) / 2 - t * (t + 1) * m
}