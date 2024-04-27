package cn_solution

fun minSwap(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    var a = 0
    var b = 1
    for (i in 1 until nums1.size) {
        var x = n
        var y = n
        if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
            x = a
            y = b + 1
        }
        if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
            x = minOf(x, b)
            y = minOf(y, a + 1)
        }
        a = x
        b = y
    }
    return minOf(a, b)
}