package cn_solution

private fun search(nums: IntArray, target: Int): Boolean {
    var l = 0
    var r = nums.lastIndex
    while (l <= r) {
        val m = (l + r) shr 1
        if (nums[m] == target)
            return true
        if (nums[l] == nums[m] && nums[m] == nums[r]) {
            l++
            r--
        } else if (nums[l] <= nums[m]) {
            if (target in nums[l]..<nums[m])
                r = m - 1
            else
                l = m + 1
        } else {
            if (target in nums[m] + 1..nums[r]) {
                l = m + 1
            } else
                r = m - 1
        }
    }
    return false
}