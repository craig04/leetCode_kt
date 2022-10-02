package cn_solution

fun findPeakElement(nums: IntArray): Int {
    var l = 0
    var r = nums.lastIndex
    while (l != r) {
        val m = (l + r) shr 1
        when {
            nums[m] > nums[m + 1] -> r = m
            nums[m] < nums[m + 1] -> l = m + 1
        }
    }
    return nums[r]
}
