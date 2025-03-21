package cn_solution

fun findUnsortedSubarray(nums: IntArray): Int {
    val n = nums.size
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    var left = n - 1
    var right = 0
    for (i in nums.indices) {
        if (nums[n - 1 - i] > min)
            left = i
        else
            min = nums[n - 1 - i]
        if (nums[i] < max)
            right = i
        else
            max = nums[i]
    }
    return if (right == 0) 0 else right - left + 1
}