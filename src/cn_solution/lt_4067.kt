package cn_solution

import kotlin.math.abs

fun maxSubarray(nums: IntArray): Int {
    val cnt = IntArray(1001)
    var i = 0
    return nums.indices.maxOf { j ->
        val y = nums[j]
        while (cnt[y] > 0) {
            val x = nums[i++]
            for (k in i until j) {
                val z = nums[k]
                cnt[x + z]--
                cnt[abs(x - z)]--
            }
        }
        for (k in i until j) {
            val z = nums[k]
            cnt[y + z]++
            cnt[abs(y - z)]++
        }
        j - i + 1
    }
}