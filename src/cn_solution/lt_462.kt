package cn_solution

import base.nthElement

fun minMoves2(nums: IntArray): Int {
    val pivot = nums.nthElement(0, nums.size, nums.size / 2)
    return nums.sumOf { Math.abs(pivot - it) }
}