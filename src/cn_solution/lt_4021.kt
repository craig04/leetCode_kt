package cn_solution

import kotlin.math.abs

private fun minOperations(s: String): Int {
    var ans = Int.MAX_VALUE
    val t = s + s
    for (i in s.indices) {
        var ops = i
        var l = i
        var r = i + s.length - 1
        while (l < r) {
            val diff = abs(t[l++] - t[r--])
            ops += minOf(diff, 26 - diff)
            if (ops >= ans)
                break
        }
        ans = minOf(ans, ops)
    }
    return ans
}