package cn_solution

fun finalElement(nums: IntArray): Int {
    return maxOf(nums[0], nums.last())
}