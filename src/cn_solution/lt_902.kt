package cn_solution

fun atMostNGivenDigitSet(digits: Array<String>, n: Int): Int {
    val bound = n.toString()
    val len = bound.length
    val candidates = digits.map { it[0] }
    val dp = IntArray(len * 2) { -1 }
    fun dfs(i: Int, limit: Boolean): Int {
        if (i == len)
            return 1
        val idx = i * 2 + if (limit) 1 else 0
        if (dp[idx] == -1) {
            dp[idx] = 0
            for (c in candidates) {
                if (limit && c > bound[i])
                    break
                dp[idx] += dfs(i + 1, limit && c == bound[i])
            }
        }
        return dp[idx]
    }
    return bound.indices.sumOf { dfs(it, it == 0) }
}