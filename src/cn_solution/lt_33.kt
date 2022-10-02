package cn_solution

private fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.lastIndex
    while (l <= r) {
        val m = (l + r) shr 1
        if (nums[m] == target)
            return m
        if (nums[l] <= nums[m]) {
            if (target in nums[l]..nums[m])
                r = m - 1
            else
                l = m + 1
        } else {
            if (target in nums[m]..nums[r])
                l = m + 1
            else
                r = m - 1
        }
    }
    return -1
}
