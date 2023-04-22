package cn_solution

fun minScoreTriangulation(values: IntArray): Int {
    val n = values.size
    val dp = Array(n) { i ->
        IntArray(n) { j ->
            when {
                i + 2 > j -> 0
                i + 2 < j -> -1
                else -> values[i] * values[i + 1] * values[j]
            }
        }
    }

    fun search(i: Int, j: Int): Int {
        if (dp[i][j] == -1) {
            dp[i][j] = (i + 1 until j).fold(Int.MAX_VALUE) { acc, k ->
                minOf(acc, values[i] * values[k] * values[j] + search(i, k) + search(k, j))
            }
        }
        return dp[i][j]
    }
    return search(0, n - 1)
}