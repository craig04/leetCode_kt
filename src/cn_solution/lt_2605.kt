package cn_solution

fun minNumber(nums1: IntArray, nums2: IntArray): Int {
    return nums1.fold(null as Int?) { acc, n ->
        if (n !in nums2) acc else minOf(acc ?: Int.MAX_VALUE, n)
    } ?: run {
        val a = nums1.min()
        val b = nums2.min()
        10 * minOf(a, b) + maxOf(a, b)
    }
}