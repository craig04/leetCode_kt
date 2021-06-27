package solution_cn

fun largestNumber(cost: IntArray, target: Int): String {
    val dp = Array<String?>(target + 1) { null }
    dp[0] = ""
    for (i in 1..target) {
        var max = ""
        for (j in 1..9) {
            val c = cost[j - 1]
            if (i < c) continue
            dp[i - c]?.let {
                max = largest(max, j.toString() + it)
            }
        }
        dp[i] = if (max == "") null else max
    }
    return dp[target] ?: "0"
}

private fun largest(s1: String, s2: String): String {
    return when {
        s1.length > s2.length -> s1
        s1.length < s2.length -> s2
        else -> maxOf(s1, s2)
    }
}