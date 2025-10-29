package cn_solution

fun missingMultiple(nums: IntArray, k: Int): Int {
    val set = nums.filterTo(HashSet()) { it % k == 0 }
    return (k..Int.MAX_VALUE step k).first { it !in set }
}