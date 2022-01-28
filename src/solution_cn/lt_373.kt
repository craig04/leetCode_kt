package solution_cn

import java.util.*
import kotlin.Comparator

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val p = PriorityQueue(Comparator<IntArray> { lhs, rhs -> lhs[0] - rhs[0] })
    for (i in nums1.indices) {
        p.add(intArrayOf(nums1[i] + nums2[0], i, 0))
    }
    return List(minOf(k, nums1.size * nums2.size)) {
        val elem = p.poll()
        val list = listOf(nums1[elem[1]], nums2[elem[2]])
        if (++elem[2] != nums2.size) {
            elem[0] = nums1[elem[1]] + nums2[elem[2]]
            p.add(elem)
        }
        list
    }
}