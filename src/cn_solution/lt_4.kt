package cn_solution

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val n = nums1.size
    val m = nums2.size
    if (n > m) {
        return findMedianSortedArrays(nums2, nums1)
    }
    fun IntArray.f(pos: Int) = when (pos) {
        -1 -> Int.MIN_VALUE
        size -> Int.MAX_VALUE
        else -> this[pos]
    }

    var l = 0
    var r = n
    var first = 0
    var second = 0
    while (l <= r) {
        val i = (l + r) shr 1
        val j = (n + m + 1) / 2 - i
        val a1 = nums1.f(i - 1)
        val b1 = nums2.f(j - 1)
        val a2 = nums1.f(i)
        val b2 = nums2.f(j)
        if (a1 > b2) {
            r = i
        } else if (b1 > a2) {
            l = i + 1
        } else {
            first = maxOf(a1, b1)
            second = minOf(a2, b2)
            break
        }
    }
    return if ((n + m) and 1 == 1) first.toDouble() else (first + second) / 2.0
}