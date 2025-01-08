package cn_solution

import kotlin.math.abs

fun countOfPairs(n: Int, x: Int, y: Int): LongArray {
    if (abs(x - y) <= 1)
        return LongArray(n) { (n - it - 1) * 2L }
    val a = minOf(x, y)
    val b = maxOf(x, y)
    val c = (a + b) / 2
    val diff = LongArray(n)
    for (i in 1..n) {
        if (i >= c) {
            diff[0]++
            diff[n - i]--
        } else {
            val t = abs(i - a)
            val d = (t + i + b + 3) / 2
            diff[0]++
            diff[d - 1 - i]--
            diff[t]++
            diff[t + 1 + b - d]--
            diff[t + 1]++
            diff[t + 1 + n - b]--
        }
    }
    val ans = LongArray(n)
    var pre = 0L
    for (i in 0 until n) {
        ans[i] = pre + diff[i] * 2
        pre = ans[i]
    }
    return ans
}
