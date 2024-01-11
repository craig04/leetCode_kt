package cn_solution

import kotlin.math.absoluteValue

fun findRotateSteps(ring: String, key: String): Int {
    val map = ring.indices.groupBy { ring[it] }
    val dp = Array(key.length + 1) { HashMap<Int, Int>() }
    dp[0][0] = 0
    for (i in key.indices) {
        val c = key[i]
        map[c]?.forEach { cur ->
            dp[i + 1][cur] = dp[i].minOf { (pre, step) ->
                val rotate = (cur - pre).absoluteValue
                step + minOf(rotate, ring.length - rotate) + 1
            }
        }
    }
    return dp.last().minOf { it.value }
}