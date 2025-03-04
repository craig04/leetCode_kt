package cn_solution

private fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
    var cnt = nums.count { it != 0 }
    if (cnt == 0)
        return 0
    val dp = Array(nums.size) { BooleanArray(nums[it] + 1) }
    dp.forEach { it[0] = true }
    for (i in queries.indices) {
        val (l, r, value) = queries[i]
        for (j in l..r) {
            if (dp[j][nums[j]])
                continue
            for (k in nums[j] downTo value)
                if (dp[j][k - value])
                    dp[j][k] = true
            if (dp[j][nums[j]] && --cnt == 0)
                return i + 1
        }
    }
    return -1
}