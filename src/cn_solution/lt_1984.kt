package cn_solution

fun minimumDifference(nums: IntArray, k: Int): Int {
    nums.sort()
    return (0..nums.size - k).fold(Int.MAX_VALUE) { res, i -> minOf(res, nums[i + k - 1] - nums[i]) }
}