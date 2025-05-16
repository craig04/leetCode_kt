package cn_solution

fun minCuttingCost(n: Int, m: Int, k: Int): Long {
    return maxOf(0, 1L * k * (maxOf(n, m) - k))
}