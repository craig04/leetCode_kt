package cn_solution

fun countSubarrays(nums: IntArray): Int {
    return (1 until nums.lastIndex).count {
        (nums[it - 1] + nums[it + 1]) * 2 == nums[it]
    }
}