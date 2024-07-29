package cn_solution

fun findIntegers(n: Int): Int {
    val s = n.toString(2)
    val dp = IntArray(s.length shl 2) { -1 }
    fun dfs(i: Int, pre: Int, limit: Int): Int {
        if (i == s.length)
            return 1
        val key = i * 4 + pre * 2 + limit * 1
        val cur = s[i] - '0'
        if (dp[key] == -1) {
            dp[key] = dfs(i + 1, 0, cur.inv() and limit)
            if (limit.inv() or cur and pre.inv() and 1 == 1)
                dp[key] += dfs(i + 1, 1, limit)
        }
        return dp[key]
    }
    return dfs(0, 0, 1)
}