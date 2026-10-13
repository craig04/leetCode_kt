package cn_solution

fun minSum(nums1: IntArray, nums2: IntArray): Long {
    fun IntArray.sumRange(): LongArray {
        var low = 0L
        var zero = false
        forEach {
            low += maxOf(1, it)
            zero = zero or (it == 0)
        }
        return longArrayOf(low, if (zero) Long.MAX_VALUE else low)
    }

    val r1 = nums1.sumRange()
    val r2 = nums2.sumRange()
    return if (r1[1] < r2[0] || r2[1] < r1[0]) -1 else maxOf(r1[0], r2[0])
}