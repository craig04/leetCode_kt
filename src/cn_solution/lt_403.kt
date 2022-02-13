package cn_solution

fun canCross(stones: IntArray): Boolean {
    val n = stones.size
    val dp = Array(n) { HashSet<Int>() }
    val map = stones.indices.associateBy { stones[it] }
    dp[0].add(1)
    for (i in 0 until n - 1) {
        for (j in dp[i]) {
            val next = map[stones[i] + j] ?: continue
            dp[next].apply {
                if (j != 1) add(j - 1)
                add(j)
                add(j + 1)
            }
        }
    }
    return dp.last().isNotEmpty()
}