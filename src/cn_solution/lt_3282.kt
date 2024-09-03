package cn_solution

fun findMaximumScore(nums: List<Int>): Long {
    var max = 0L
    return (0 until nums.lastIndex).sumOf {
        max = maxOf(max, nums[it] + 0L)
        max
    }
}