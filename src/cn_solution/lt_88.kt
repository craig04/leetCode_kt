package cn_solution

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var p1 = m - 1
    var p2 = n - 1
    var p = m + n - 1
    while (p1 >= 0 && p2 >= 0) {
        nums1[p--] = if (nums1[p1] > nums2[p2]) nums1[p1--] else nums2[p2--]
    }
    for (i in 0..p2) {
        nums1[i] = nums2[i]
    }
}