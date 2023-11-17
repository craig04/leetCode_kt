package cn_lcr

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val dp = Array(target + 1) { ArrayList<List<Int>>() }
    dp[0].add(emptyList())
    for (c in candidates)
        for (j in c..target)
            dp[j - c].mapTo(dp[j]) { ArrayList(it).apply { add(c) } }
    return dp[target]
}