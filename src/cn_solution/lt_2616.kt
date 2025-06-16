package cn_solution

import kotlin.math.abs

fun minimizeMax(nums: IntArray, p: Int): Int {
    if (p == 0)
        return 0
    nums.sort()
    val n = nums.size
    var l = Int.MAX_VALUE
    var r = Int.MIN_VALUE
    for (i in 1 until n) {
        val diff = nums[i] - nums[i - 1]
        l = minOf(l, diff)
        r = maxOf(r, diff)
    }
    while (l != r) {
        val m = (l + r) / 2
        fun check(): Boolean {
            var cnt = 0
            var i = 1
            while (i < n) {
                if (abs(nums[i] - nums[i - 1]) > m) {
                    i++
                    continue
                }
                i += 2
                if (++cnt >= p)
                    return true
            }
            return false
        }
        if (check())
            r = m
        else
            l = m + 1
    }
    return l
}