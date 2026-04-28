package cn_solution

fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    var i = 0
    var j = 0
    val n = nums1.size
    val m = nums2.size
    while (i != n && j != m) {
        when (nums1[i].compareTo(nums2[j])) {
            0 -> return nums1[i]
            1 -> j++
            else -> i++
        }
    }
    return -1
}