package cn_solution

fun waysToReachTarget(target: Int, types: Array<IntArray>): Int {
    val dp = IntArray(target + 1)
    dp[0] = 1
    for ((cnt, mark) in types) {
        for (s in target downTo 0)
            for (c in 1..cnt) {
                val t = s - c * mark
                if (t >= 0)
                    dp[s] = (dp[s] + dp[t]) % 1000000007
            }
    }
    return dp[target]
}