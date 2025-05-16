package cn_solution

import java.util.*

fun minimumDifference(nums: IntArray): Long {
    val m = nums.size
    val n = m / 3
    val max = PriorityQueue<Int>(Comparator.reverseOrder())
    val min = PriorityQueue<Int>()
    val pre = LongArray(m)
    val suf = LongArray(m)
    var left = 0L
    var right = 0L
    for (i in 0 until m) {
        if (max.size < n || nums[i] < max.peek()) {
            left += nums[i]
            max.add(nums[i])
        }
        if (max.size > n)
            left -= max.poll()
        pre[i] = left
        val j = m - 1 - i
        if (min.size < n || nums[j] > min.peek()) {
            right += nums[j]
            min.add(nums[j])
        }
        if (min.size > n)
            right -= min.poll()
        suf[j] = right
    }
    return (n..2 * n).minOf { pre[it - 1] - suf[it] }
}