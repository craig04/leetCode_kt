package cn_solution

fun numberOfChild(n: Int, k: Int): Int {
    val y = k % (n - 1)
    return if (k / (n - 1) % 2 == 0) y else n - 1 - y
}