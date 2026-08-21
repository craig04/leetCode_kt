package cn_solution

private fun firstStableIndex(nums: IntArray, k: Int): Int {
    val n = nums.size
    val suf = IntArray(n + 1)
    suf[n] = Int.MAX_VALUE
    for (i in n - 1 downTo 0)
        suf[i] = minOf(suf[i + 1], nums[i])
    var pre = 0
    return (0 until n).indexOfFirst { i ->
        pre = maxOf(pre, nums[i])
        pre - suf[i] <= k
    }
}