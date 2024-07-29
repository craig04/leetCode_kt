package cn_solution

import java.util.*

fun findValidSplit(nums: IntArray): Int {
    val n = nums.size
    if (n == 1)
        return -1
    val pos = HashMap<Int, IntArray>()
    for (i in nums.indices) {
        val a = pos.computeIfAbsent(nums[i]) { intArrayOf(Int.MAX_VALUE, -1) }
        a[0] = minOf(a[0], i)
        a[1] = maxOf(a[1], i)
    }
    val right = IntArray(n) { it }
    val f = BooleanArray(1 + nums.max())
    for (i in 2 until f.size) {
        if (f[i])
            continue
        var l = Int.MAX_VALUE
        var r = -1
        for (j in i until f.size step i) {
            f[j] = true
            val a = pos[j] ?: continue
            l = minOf(l, a[0])
            r = maxOf(r, a[1])
        }
        if (r != -1 && l != r)
            right[l] = maxOf(right[l], r)
    }
    var ans = 0
    for (i in nums.indices) {
        ans = maxOf(ans, right[i])
        if (ans == n - 1 || ans == i)
            break
    }
    return if (ans == n - 1) -1 else ans
}