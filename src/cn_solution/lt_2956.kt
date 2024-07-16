package cn_solution

fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toHashSet()
    val set2 = nums2.toHashSet()
    return intArrayOf(nums1.count { it in set2 }, nums2.count { it in set1 })
}