package cn_solution

private fun minCost(nums: IntArray): Long {
    var even = 0L
    var odd = Long.MAX_VALUE / 2
    for (i in 1 until nums.lastIndex) {
        val x = nums[i]
        val t = minOf(even, odd + x)
        odd = minOf(odd, even + x)
        even = t
    }
    return even + nums.first() + nums.last()
}