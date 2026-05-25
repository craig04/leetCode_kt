package cn_solution

private fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.lastIndex
    while (l <= r) {
        val m = (l + r) shr 1
        if (nums[m] == target)
            return m
        else if (target in nums[l]..nums[m] || nums[m] < nums[r] && target !in nums[m]..nums[r])
            r = m - 1
        else
            l = m + 1
    }
    return -1
}