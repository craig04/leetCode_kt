package cn_solution

fun partitionDisjoint(nums: IntArray): Int {
    var result = 1
    var allMax = nums[0]
    var curMax = nums[0]
    for (i in 1 until nums.lastIndex) {
        if (nums[i] < curMax) {
            result = i + 1
            curMax = allMax
        }
        allMax = nums[i]
    }
    return result
}