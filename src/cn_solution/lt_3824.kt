package cn_solution

import kotlin.math.cbrt
import kotlin.math.ceil
import kotlin.math.sqrt

fun minimumK(nums: IntArray): Int {
        var max = 0
        var sum = 0L
        for (num in nums) {
            max = maxOf(max, num)
            sum += num
        }
        var l = maxOf(
            ceil(sqrt(nums.size + 0.0)).toInt() - 1,
            ceil(cbrt(sum + 0.0)).toInt() - 1,
            1
        )
        var r = maxOf(nums.max(), ceil(sqrt(nums.size + 0.0)).toInt())
        while (l < r) {
            val m = (l + r) / 2
            val cnt = nums.sumOf { (it + m - 1) / m }
            if (cnt <= m * 1L * m)
                r = m
            else
                l = m + 1
        }
        return l
    }