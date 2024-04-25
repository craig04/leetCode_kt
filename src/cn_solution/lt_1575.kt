package cn_solution

import kotlin.math.absoluteValue

fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
    val modulo = 1000000007
    val n = locations.size
    val dp = Array(n) { IntArray(fuel + 1) { -1 } }
    fun dfs(i: Int, f: Int): Int {
        if (dp[i][f] != -1)
            return dp[i][f]
        if ((locations[i] - locations[finish]).absoluteValue > f) {
            dp[i][f] = 0
            return 0
        }
        var cnt = if (i == finish) 1 else 0
        for (j in 0 until n) {
            val cost = (locations[i] - locations[j]).absoluteValue
            if (cost in 1..f)
                cnt = (cnt + dfs(j, f - cost)) % modulo
        }
        dp[i][f] = cnt
        return dp[i][f]
    }
    return dfs(start, fuel)
}