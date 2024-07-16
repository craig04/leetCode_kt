package cn_solution

fun minPairSum(nums: IntArray): Int {
    nums.sort()
    val s = nums.lastIndex
    return (0 until nums.size / 2).maxOf { nums[it] + nums[s - it] }
}