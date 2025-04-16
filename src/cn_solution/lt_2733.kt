package cn_solution

fun findNonMinOrMax(nums: IntArray): Int {
    if (nums.size < 3)
        return -1
    nums.sort(0, 3)
    return nums[1]
}