package cn_solution

private fun minOperations(nums1: IntArray, nums2: IntArray): Long {
    val dst = nums2.last()
    var min = Int.MAX_VALUE
    return nums1.indices.fold(1L) { ans, i ->
        val x = minOf(nums1[i], nums2[i])
        val y = maxOf(nums1[i], nums2[i])
        min = minOf(min, maxOf(x - dst, dst - y))
        ans + y - x
    } + maxOf(0, min)
}