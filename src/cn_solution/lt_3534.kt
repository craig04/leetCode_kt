package cn_solution

private fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): IntArray {
    if (n == 1)
        return IntArray(queries.size)
    val m = 33 - (n - 2).countLeadingZeroBits()
    val sort = Array(n) { it }
    sort.sortBy { nums[it] }
    nums.sort()
    val dp = Array(n) { IntArray(m) }
    var j = 0
    for (i in 0 until n) {
        while (j < n && nums[j] - nums[i] <= maxDiff)
            j++
        dp[i][0] = j - 1
    }
    for (j in 1 until m)
        for (i in 0 until n)
            dp[i][j] = dp[dp[i][j - 1]][j - 1]
    val map = IntArray(n)
    for (i in 0 until n)
        map[sort[i]] = i
    return IntArray(queries.size) {
        val a = map[queries[it][0]]
        val b = map[queries[it][1]]
        if (a == b)
            return@IntArray 0
        var s = minOf(a, b)
        val e = maxOf(a, b)
        if (dp[s].last() < e)
            return@IntArray -1
        var ans = 1
        for (i in m - 1 downTo 0)
            if (dp[s][i] < e) {
                ans += 1 shl i
                s = dp[s][i]
            }
        ans
    }
}