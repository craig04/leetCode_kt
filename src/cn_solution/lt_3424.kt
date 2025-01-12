package cn_solution

import kotlin.math.abs

fun minCost(arr: IntArray, brr: IntArray, k: Long): Long {
    fun cost() = arr.indices.sumOf { abs(arr[it] - brr[it]) + 0L }
    val ans = cost()
    if (k >= ans)
        return ans
    arr.sort()
    brr.sort()
    return minOf(ans, cost() + k)
}
