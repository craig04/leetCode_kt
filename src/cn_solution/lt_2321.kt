package cn_solution

fun maximumsSplicedArray(nums1: IntArray, nums2: IntArray): Int {
    var sum1 = 0
    var sum2 = 0
    var tmp1 = 0
    var tmp2 = 0
    var sub1 = 0
    var sub2 = 0
    for (i in nums1.indices) {
        val diff = nums1[i] - nums2[i]
        sum1 += nums1[i]
        sum2 += nums2[i]
        tmp1 = maxOf(tmp1 + diff, 0)
        tmp2 = maxOf(tmp2 - diff, 0)
        sub1 = maxOf(sub1, tmp1)
        sub2 = maxOf(sub2, tmp2)
    }
    return maxOf(sum1 + sub1, sum2 + sub2)
}