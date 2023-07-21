package cn_solution

import java.util.*

fun minAbsoluteDifference(nums: List<Int>, x: Int): Int {
    val set = TreeSet<Int>()
    var result = Int.MAX_VALUE
    nums.forEachIndexed { i, n ->
        if (i >= x)
            set.add(nums[i - x])
        set.ceiling(n)?.let {
            result = minOf(result, it - n)
        }
        set.floor(n)?.let {
            result = minOf(result, n - it)
        }
    }
    return result
}