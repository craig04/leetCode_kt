package solution_cn

private fun findMin(nums: IntArray): Int {
    var l = 0
    var r = nums.lastIndex
    while (nums[l] > nums[r]) {
        val m = (l + r) shr 1
        if (nums[m] >= nums[l]) {
            l = m + 1
        } else {
            r = m
        }
    }
    return nums[l]
}