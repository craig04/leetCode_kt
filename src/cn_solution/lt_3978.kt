package cn_solution

fun isMiddleElementUnique(nums: IntArray): Boolean {
    val x = nums[nums.size / 2]
    return nums.count { it == x } == 1
}