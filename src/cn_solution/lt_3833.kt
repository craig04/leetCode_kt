package cn_solution

fun dominantIndices(nums: IntArray): Int {
    val n = nums.size
    var sum = 0
    return (n - 1 downTo 1).count { i ->
        sum += nums[i]
        nums[i - 1] * (n - i) > sum
    }
}