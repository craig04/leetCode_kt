package cn_solution

private fun maximumTripletValue(nums: IntArray): Long {
    val n = nums.size
    val suf = IntArray(n + 1)
    for (i in nums.indices.reversed())
        suf[i] = maxOf(suf[i + 1], nums[i])
    var pre = nums[0]
    var ans = 0L
    for (i in 1 until n - 1) {
        ans = maxOf(ans, (pre - nums[i]) * 1L * suf[i + 1])
        pre = maxOf(pre, nums[i])
    }
    return ans
}