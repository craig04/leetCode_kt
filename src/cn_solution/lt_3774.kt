package cn_solution

fun absDifference(nums: IntArray, k: Int): Int {
    nums.sort()
    val t = nums.lastIndex
    return (0 until k).sumOf { i -> nums[t - i] - nums[i] }
}