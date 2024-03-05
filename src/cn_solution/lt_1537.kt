package cn_solution

fun maxSum(nums1: IntArray, nums2: IntArray): Int {
    val n1 = nums1.size
    val n2 = nums2.size
    var i1 = 0
    var i2 = 0
    var sum1 = 0L
    var sum2 = 0L
    var result = 0L
    while (i1 != n1 && i2 != n2) {
        if (nums1[i1] == nums2[i2]) {
            result += maxOf(sum1, sum2) + nums1[i1]
            sum1 = 0
            sum2 = 0
            i1++
            i2++
        } else if (nums1[i1] < nums2[i2]) {
            sum1 += nums1[i1++]
        } else {
            sum2 += nums2[i2++]
        }
    }
    while (i1 != n1)
        sum1 += nums1[i1++]
    while (i2 != n2)
        sum2 += nums2[i2++]
    return ((result + maxOf(sum1, sum2)) % 1000000007).toInt()
}