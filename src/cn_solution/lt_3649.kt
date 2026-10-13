package cn_solution

import kotlin.math.abs

fun perfectPairs(nums: IntArray): Long {
    val a = IntArray(nums.size) { abs(nums[it]) }
    a.sort()
    var i = 0
    return a.indices.sumOf { j ->
        while (a[i] * 2 < a[j])
            i++
        j - i + 0L
    }
}