package cn_solution

fun waysToSplitArray(nums: IntArray): Int {
    var left = 0L
    var right = nums.fold(0L) { acc, num -> acc + num }
    return (0 until nums.lastIndex).count {
        left += nums[it]
        right -= nums[it]
        left >= right
    }
}