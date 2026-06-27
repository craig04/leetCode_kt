package cn_solution

import kotlin.math.abs

private fun minOperations(nums: IntArray, k: Int): Int {
    fun operations(start: Int): IntArray {
        return IntArray(k) { i ->
            (start until nums.size step 2).sumOf { j ->
                val d = abs(nums[j] % k - i)
                minOf(d, k - d)
            }
        }
    }

    val even = operations(0)
    val odd = operations(1)
    var ans = Int.MAX_VALUE
    for (x in 0 until k)
        for (y in 0 until k)
            if (x != y)
                ans = minOf(ans, even[x] + odd[y])
    return ans
}