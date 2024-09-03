package cn_solution

import kotlin.math.sign

private fun countSubarrays(nums: IntArray, k: Int): Int {
    val n = nums.size
    val index = nums.indexOf(k)
    val map = IntArray(n * 2 + 1)
    var bigger = 0
    for (i in index downTo 0) {
        bigger += (nums[i] - k).sign
        map[bigger + n]++
    }
    var smaller = 0
    return (index until n).sumBy {
        smaller += (k - nums[it]).sign
        map[smaller + n] + map[smaller + 1 + n]
    }
}