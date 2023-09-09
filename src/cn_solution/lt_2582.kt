package cn_solution

fun passThePillow(n: Int, time: Int): Int {
    val r = time % (2 * n - 2) + 1
    return if (r < n) r else 2 * n - r
}