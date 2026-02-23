package cn_solution

fun smallestEqual(nums: IntArray): Int {
    return nums.indices.indexOfFirst { it % 10 == nums[it] }
}