package cn_solution

import kotlin.math.abs
import kotlin.math.sign

fun minimumOperations(nums: IntArray, target: IntArray): Long {
    var pre = 0
    return nums.indices.fold(0L) { acc, i ->
        val cur = target[i] - nums[i]
        val delta = if (cur.sign == pre.sign) {
            maxOf(abs(cur) - abs(pre), 0)
        } else {
            abs(cur)
        }
        pre = cur
        acc + delta
    }
}