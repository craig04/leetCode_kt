package cn_solution

fun minimumDeletions(nums: IntArray): Int {
    var min = 0
    var max = 0
    for (i in nums.indices) {
        if (nums[i] > nums[max])
            max = i
        if (nums[i] < nums[min])
            min = i
    }
    val n = nums.size
    val l = minOf(min, max)
    val r = maxOf(min, max)
    return minOf(r + 1, n - l, n + l - r + 1)
}