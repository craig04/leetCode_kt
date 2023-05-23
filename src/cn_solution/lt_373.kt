package cn_solution

import java.util.*

fun kSmallestPairs_binarySearch(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    var left = nums1.first() + nums2.first()
    var right = nums1.last() + nums2.last()
    val size = if (k / nums1.size >= nums2.size) nums1.size * nums2.size else k
    while (left != right) {
        val m = left + (right - left + 1).shr(1)
        var j = nums2.size
        val count = nums1.fold(0L) { acc, it ->
            while (j != 0 && it + nums2[j - 1] >= m)
                j--
            acc + j
        }
        if (count < size) left = m else right = m - 1
    }
    val result = LinkedList<List<Int>>()
    for (p in nums1) {
        inner@ for (q in nums2) {
            when {
                p + q > left -> break@inner
                p + q < left -> result.addFirst(listOf(p, q))
                result.size < size -> result.addLast(listOf(p, q))
            }
        }
    }
    return result.subList(0, size)
}

fun kSmallestPairs_priorityQueue(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val p = PriorityQueue(Comparator<IntArray> { lhs, rhs -> lhs[0] - rhs[0] })
    for (i in nums1.indices) {
        p.add(intArrayOf(nums1[i] + nums2[0], i, 0))
    }
    var size = k
    if (size / nums1.size >= nums2.size) {
        size = nums1.size * nums2.size
    }
    return List(size) {
        val elem = p.poll()
        val list = listOf(nums1[elem[1]], nums2[elem[2]])
        if (++elem[2] != nums2.size) {
            elem[0] = nums1[elem[1]] + nums2[elem[2]]
            p.add(elem)
        }
        list
    }
}