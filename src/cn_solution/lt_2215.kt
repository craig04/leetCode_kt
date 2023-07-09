package cn_solution

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val set1 = nums1.toHashSet()
    val set2 = nums2.toHashSet()
    return listOf(set1.filter { !set2.remove(it) }, set2.toList())
}