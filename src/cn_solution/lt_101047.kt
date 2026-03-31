package cn_solution

private fun firstStableIndex(nums: IntArray, k: Int): Int {
    val n = nums.size
    val suf = IntArray(n + 1)
    suf[n] = Int.MAX_VALUE
    for (i in n - 1 downTo 0)
        suf[i] = minOf(suf[i + 1], nums[i])
    var pre = 0
    for (i in 0 until n) {
        pre = maxOf(pre, nums[i])
        if (pre - suf[i] <= k)
            return i
    }
    return -1
}