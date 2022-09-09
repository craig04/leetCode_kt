package cn_solution

fun containsDuplicate(nums: IntArray): Boolean {
    val set = HashSet<Int>()
    return nums.any { !set.add(it) }
}