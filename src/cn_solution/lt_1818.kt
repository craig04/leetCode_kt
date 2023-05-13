package cn_solution

fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {
    val sorted = nums1.sortedArray()
    val n = nums1.size
    var sum = 0L
    var adjust = 0
    outer@ for (i in nums1.indices) {
        val diff = Math.abs(nums1[i] - nums2[i])
        sum += diff
        var l = 0
        var r = n
        while (l != r) {
            val m = (l + r) shr 1
            val temp = sorted[m]
            when {
                temp > nums2[i] -> r = m
                temp < nums2[i] -> l = m + 1
                else -> {
                    adjust = maxOf(adjust, diff)
                    continue@outer
                }
            }
        }
        if (r != 0) adjust = maxOf(adjust, diff - Math.abs(sorted[r - 1] - nums2[i]))
        if (r != n) adjust = maxOf(adjust, diff - Math.abs(sorted[r] - nums2[i]))
    }
    return ((sum - adjust) % 1000000007).toInt()
}