package cn_solution

private fun minCost(nums: IntArray): Long {
    val n = nums.size
    var i = 0
    var ans = Long.MAX_VALUE
    while (i != n) {
        var j = i + 1
        while (j != n && nums[i] == nums[j])
            j++
        if (i != j - 1 || (i != 0 && j != n))
            ans = minOf(ans, 1L * nums[i] * (i + n - j))
        i = j
    }
    return ans
}