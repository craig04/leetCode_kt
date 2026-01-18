package cn_solution

fun minimumPrefixLength(nums: IntArray): Int {
    for (i in nums.size - 1 downTo 1)
        if (nums[i - 1] >= nums[i])
            return i
    return 0
}