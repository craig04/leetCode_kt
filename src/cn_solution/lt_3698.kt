package cn_solution

import kotlin.math.abs

private fun splitArray(nums: IntArray): Long {
    val n = nums.size
    var pre = 0L + nums[0]
    var i = 1
    while (i < n && nums[i - 1] < nums[i])
        pre += nums[i++]
    var suf = 0L + nums[n - 1]
    var j = n - 2
    while (j != 0 && nums[j] > nums[j + 1])
        suf += nums[j--]
    val dif = pre - suf
    val num = nums[i - 1]
    return when {
        i - 1 < j -> -1
        i - 1 == j -> abs(dif)
        else -> minOf(abs(dif - num), abs(dif + num))
    }
}