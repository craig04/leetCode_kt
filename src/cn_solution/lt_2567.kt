package cn_solution

fun minimizeSum(nums: IntArray): Int {
    nums.sort()
    val n = nums.size
    return minOf(
        nums[n - 1] - nums[2],
        nums[n - 2] - nums[1],
        nums[n - 3], nums[0]
    )
}