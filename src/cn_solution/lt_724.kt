package cn_solution

fun pivotIndex(nums: IntArray): Int {
    val total = nums.sum()
    var sum = 0
    for (i in nums.indices) {
        if (sum == total - sum - nums[i])
            return i
        sum += nums[i]
    }
    return -1
}