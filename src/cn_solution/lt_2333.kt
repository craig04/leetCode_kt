package cn_solution

import kotlin.math.abs

fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
    val n = nums1.size
    val d = LongArray(n + 1)
    var sum = 0L
    var ans = 0L
    for (i in 0 until n) {
        d[i] += abs(nums1[i] - nums2[i])
        sum += d[i]
        ans += d[i] * d[i]
    }
    if (sum <= k1 + k2)
        return 0
    var k = 0L + k1 + k2
    d.sortDescending()
    for (i in 1..n) {
        val pre = d[i - 1]
        ans -= pre * pre
        val cnt = i * (pre - d[i])
        if (cnt > k) {
            val x = pre - k / i
            ans += i * x * x - k % i * (2 * x - 1)
            break
        }
        k -= cnt
    }
    return ans
}