package cn_solution

fun numberOfPairs(nums1: IntArray, nums2: IntArray, diff: Int): Long {
    val upper = 50002
    val offset = 20001
    val a = IntArray(upper)
    return nums1.indices.sumOf {
        val target = nums1[it] - nums2[it] + offset
        var t = target + diff
        var count = 0L
        while (t > 0) {
            count += a[t]
            t -= t and -t
        }
        t = target
        while (t < upper) {
            a[t]++
            t += t and -t
        }
        count
    }
}