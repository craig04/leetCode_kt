package cn_solution

private fun longestSubarray(nums: IntArray): Int {
    val n = nums.size
    if (n <= 2)
        return n
    val suf = IntArray(n) { 1 }
    suf[n - 1] = 1
    for (i in n - 2 downTo 0)
        if (nums[i] <= nums[i + 1])
            suf[i] += suf[i + 1]
    var pre = 1
    var ans = suf[1] + 1
    for (i in 1 until n - 1) {
        ans = if (nums[i - 1] <= nums[i + 1])
            maxOf(ans, pre + suf[i + 1] + 1)
        else
            maxOf(ans, pre + 1, suf[i + 1] + 1)
        if (nums[i - 1] > nums[i])
            pre = 0
        pre++
    }
    return maxOf(ans, pre + 1)
}