package cn_solution

import java.util.*

fun maxKDistinct(nums: IntArray, k: Int): IntArray {
    val set = TreeSet(nums.asList())
    return IntArray(minOf(k, set.size)) { set.pollLast() ?: 0 }
}