package cn_solution

fun findSubarrays(nums: IntArray): Boolean {
    val set = HashSet<Int>()
    return (1 until nums.size).any { !set.add(nums[it - 1] + nums[it]) }
}