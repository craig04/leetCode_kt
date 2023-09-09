package cn_lcr

import java.util.PriorityQueue

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    fun sum(n: Int) = nums1[n shr 16] + nums2[n and 0xffff]
    val q = PriorityQueue<Int> { lhs, rhs -> sum(lhs) - sum(rhs) }
    for (i in nums1.indices)
        q.offer(i shl 16)
    val result = ArrayList<List<Int>>()
    repeat(minOf(k, nums1.size * nums2.size)) {
        val t = q.poll()
        val i = t shr 16
        val j = t and 0xffff
        result.add(listOf(nums1[i], nums2[j]))
        if (j != nums2.lastIndex)
            q.offer(t + 1)
    }
    return result
}