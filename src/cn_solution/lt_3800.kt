package cn_solution

fun minimumCost(s: String, t: String, flipCost: Int, swapCost: Int, crossCost: Int): Long {
    var a = 0
    var b = 0
    for (i in s.indices) {
        when (s[i]) {
            t[i] -> continue
            '0' -> a++
            '1' -> b++
        }
    }
    val n = minOf(a, b)
    val m = a + b - 2 * n
    val x = n * 1L * minOf(2 * flipCost, swapCost)
    val y = m / 2L * minOf(2 * flipCost, swapCost + crossCost)
    val z = m % 2L * flipCost
    return x + y + z
}