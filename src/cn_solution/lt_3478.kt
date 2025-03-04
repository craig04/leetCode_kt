package cn_solution

import java.util.*

fun findMaxSum(nums1: IntArray, nums2: IntArray, k: Int): LongArray {
    val n = nums1.size
    val a = Array(n) { intArrayOf(nums1[it], nums2[it], it) }
    a.sortBy { it[0] }
    val ans = LongArray(n)
    var sum = 0L
    val q = PriorityQueue<Int>()
    for (i in 0 until n) {
        val (x, y, t) = a[i]
        ans[t] = if (i == 0 || x != a[i - 1][0])
            sum
        else
            ans[a[i - 1][2]]
        if (q.size < k || y > q.peek()) {
            q.add(y)
            sum += y
            if (q.size > k)
                sum -= q.poll()
        }
    }
    return ans
}