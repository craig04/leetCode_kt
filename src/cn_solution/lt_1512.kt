package cn_solution

fun numIdenticalPairs(nums: IntArray): Int {
    val cnt = HashMap<Int, Int>()
    return nums.sumOf { (cnt.merge(it, 1, Int::plus) ?: 1) - 1 }
}