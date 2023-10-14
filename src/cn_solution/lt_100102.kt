package cn_solution

fun minSum(nums1: IntArray, nums2: IntArray): Long {
    var sum1 = 0L
    var sum2 = 0L
    var pos1 = true
    var pos2 = true
    for (n in nums1) {
        pos1 = pos1.and(n != 0)
        sum1 += maxOf(1, n)
    }
    for (n in nums2) {
        pos2 = pos2.and(n != 0)
        sum2 += maxOf(1, n)
    }
    if ((pos1 && pos2 && sum1 != sum2) ||
        (pos1 && sum1 < sum2) ||
        (pos2 && sum2 < sum1)
    )
        return -1
    return maxOf(sum1, sum2)
}