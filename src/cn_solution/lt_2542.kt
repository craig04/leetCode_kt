package cn_solution

import java.util.*

fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val indices = nums1.indices.sortedByDescending { nums2[it] }
    val q = PriorityQueue<Int>()
    var sum = 0L
    var result = 0L
    indices.forEachIndexed { i, t ->
        sum += nums1[t]
        q.offer(nums1[t])
        if (i >= k - 1) {
            result = maxOf(result, sum * nums2[i])
            sum -= q.poll()
        }
    }
    return result
}