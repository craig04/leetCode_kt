package cn_solution

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val s1 = nums1.toHashSet()
    val res = nums2.filterTo(HashSet()) { it in s1 }
    return res.toIntArray()
}