package cn_solution

import kotlin.math.abs

private fun minSwaps(nums: IntArray): Int {
    val n = nums.size
    val odds = nums.indices.filter { nums[it] and 1 == 1 }
    fun count(pos: Int): Int {
        return odds.indices.sumOf { i ->
            abs(odds[i] - 2 * i - pos)
        }
    }

    var ans = Int.MAX_VALUE
    if (odds.size == (n + 1) / 2)
        ans = minOf(ans, count(0))
    if (odds.size == n / 2)
        ans = minOf(ans, count(1))
    return if (ans == Int.MAX_VALUE) -1 else ans
}