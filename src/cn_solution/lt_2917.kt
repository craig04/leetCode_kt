package cn_solution

fun findKOr(nums: IntArray, k: Int): Int {
    return (0 until 31).asSequence()
        .map { 1 shl it }
        .filter { nums.count { n -> n and it != 0 } >= k }
        .sum()
}