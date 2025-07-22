package cn_solution

import java.util.*

private fun minOperations(nums: IntArray, x: Int, k: Int): Long {
    val n = nums.size
    val dp = Array(n + 1) { LongArray(k + 1) { Long.MAX_VALUE / 2 } }
    dp[0][0] = 0
    val p = TreeSet<Long>()
    val q = TreeSet<Long>()
    var u = 0L
    var v = 0L
    fun balance() {
        if (p.size < q.size) {
            val o = q.pollFirst()!!
            val num = o shr 32
            p.add(o)
            u += num
            v -= num
        } else if (p.size == q.size + 2) {
            val o = p.pollLast()!!
            val num = o shr 32
            q.add(o)
            u -= num
            v += num
        }
    }
    for (i in nums.indices) {
        val mid = if (p.isEmpty()) Long.MAX_VALUE else p.last() shr 32
        val num = nums[i].toLong()
        val key = num.shl(32) + i
        if (nums[i] < mid || num == mid && p.size == q.size) {
            p.add(key)
            u += num
        } else {
            q.add(key)
            v += num
        }
        balance()
        dp[i + 1][0] = 0
        if (i >= x - 1) {
            val ops = v - u + (x and 1) * (p.last() shr 32)
            for (t in 1..k)
                dp[i + 1][t] = minOf(dp[i][t], dp[i + 1 - x][t - 1] + ops)
            val j = i - x + 1
            val key = nums[j].toLong().shl(32) + j
            if (p.remove(key))
                u -= nums[j]
            if (q.remove(key))
                v -= nums[j]
            balance()
        }
    }
    return dp[n][k]
}