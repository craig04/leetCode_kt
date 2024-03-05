package cn_solution

fun maximumCount(nums: IntArray): Int {
    var l = 0
    var r = nums.size
    while (l != r) {
        val m = (l + r) shr 1
        if (nums[m] <= 0)
            l = m + 1
        else
            r = m
    }
    val positive = nums.size - r
    l = -1
    r = nums.lastIndex
    while (l != r) {
        val m = (l + r + 1) shr 1
        if (nums[m] >= 0)
            r = m - 1
        else
            l = m
    }
    return maxOf(positive, r + 1)
}