package cn_solution

fun triangularSum(nums: IntArray): Int {
    for (i in nums.lastIndex downTo 1)
        for (j in 0 until i)
            nums[j] = (nums[j] + nums[j + 1]) % 10
    return nums[0]
}