package cn_solution

private fun countSubarrays(nums: IntArray, k: Long): Long {
    var sum = 0L
    var i = -1
    return nums.indices.sumOf { j ->
        sum += nums[j]
        while (sum * (j - i) >= k)
            sum -= nums[++i]
        0L + j - i
    }
}