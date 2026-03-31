package cn_solution

fun minIncrease(nums: IntArray): Long {
    val n = nums.size
    val m = (n - 1) / 2
    val pre = LongArray(m + 1)
    val suf = LongArray(m + 1)
    for (t in 1..m) {
        val i = t * 2 - 1
        val j = nums.size - t * 2
        pre[t] = pre[t - 1] + maxOf(nums[i], nums[i - 1] + 1, nums[i + 1] + 1) - nums[i]
        suf[t] = suf[t - 1] + maxOf(nums[j], nums[j - 1] + 1, nums[j + 1] + 1) - nums[j]
    }
    return (0..m).minOf { pre[it] + suf[m - it] }
}