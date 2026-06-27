package cn_solution

fun minCost(source: String, target: String, rules: List<List<String>>, costs: IntArray): Int {
    rules.forEachIndexed { i, (p) -> costs[i] += p.count { it == '*' } }
    val n = source.length
    val dp = IntArray(n + 1) { Int.MAX_VALUE / 2 }
    dp[n] = 0
    for (i in source.indices.reversed()) {
        if (source[i] == target[i])
            dp[i] = dp[i + 1]
        rules.forEachIndexed { t, (p, r) ->
            if (p.length <= n - i) {
                for (j in p.indices)
                    if (p[j] != '*' && p[j] != source[i + j] || r[j] != target[i + j])
                        return@forEachIndexed
                dp[i] = minOf(dp[i], dp[i + p.length] + costs[t])
            }
        }
    }
    return if (dp[0] >= Int.MAX_VALUE / 2) -1 else dp[0]
}