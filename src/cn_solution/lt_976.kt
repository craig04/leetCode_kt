package cn_solution

fun largestPerimeter(nums: IntArray): Int {
    nums.sortDescending()
    for (i in 2 until nums.size)
        if (nums[i - 2] < nums[i - 1] + nums[i])
            return nums[i - 2] + nums[i - 1] + nums[i]
    return 0
}