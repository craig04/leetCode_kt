package cn_solution

fun minOperations(nums: IntArray): Int {
    return if (nums.all { it == nums[0] }) 0 else 1
}