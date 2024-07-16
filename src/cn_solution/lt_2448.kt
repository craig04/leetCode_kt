package cn_solution

import kotlin.math.abs

private fun minCost(nums: IntArray, cost: IntArray): Long {
    val idx = Array(nums.size) { it }
    idx.sortBy { nums[it] }
    val target = (cost.fold(0L) { sum, c -> sum + c } + 1) / 2
    var sum = 0L
    val pivot = idx.first {
        sum += cost[it]
        sum >= target
    }
    val median = nums[pivot]
    return nums.indices.sumOf { abs(nums[it] - median) * cost[it].toLong() }
}