package cn_solution

fun minImpossibleOR(nums: IntArray): Int {
    val set = nums.toSet()
    return (0 until 31).map { 1 shl it }.first { it !in set }
}