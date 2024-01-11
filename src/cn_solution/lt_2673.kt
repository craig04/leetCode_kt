package cn_solution

import kotlin.math.abs

fun minIncrements(n: Int, cost: IntArray): Int {
    var result = 0
    fun dfs(i: Int): Int {
        if (i >= n)
            return 0
        val left = dfs(i * 2 + 1)
        val right = dfs(i * 2 + 2)
        result += abs(left - right)
        return maxOf(left, right) + cost[i]
    }
    return dfs(0)
}