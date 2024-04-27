package cn_solution

private fun maxOperations(nums: IntArray): Int {
    val n = nums.size
    val t = intArrayOf(0, 1, 0, n - 1, n - 2, n - 1)
    val dp = Array(n) { IntArray(n) }
    return (t.indices step 2)
        .mapTo(HashSet()) { nums[t[it]] + nums[t[it + 1]] }
        .maxOf { sum ->
            dp.forEach { it.fill(-1) }
            fun dfs(l: Int, r: Int): Int {
                if (l >= r)
                    return 0
                if (dp[l][r] == -1) {
                    var ans = 0
                    if (nums[l] + nums[l + 1] == sum)
                        ans = maxOf(ans, dfs(l + 2, r) + 1)
                    if (nums[l] + nums[r] == sum)
                        ans = maxOf(ans, dfs(l + 1, r - 1) + 1)
                    if (nums[r - 1] + nums[r] == sum)
                        ans = maxOf(ans, dfs(l, r - 2) + 1)
                    dp[l][r] = ans
                }
                return dp[l][r]
            }
            dfs(0, n - 1)
        }
}