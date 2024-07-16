package cn_solution

private fun incremovableSubarrayCount(nums: IntArray): Int {
    val n = nums.size
    var l = 1
    while (l != n && nums[l - 1] < nums[l])
        l++
    if (l == n)
        return n * (n + 1) / 2
    var ans = 0
    var r = n - 1
    var next = Int.MAX_VALUE
    while (--l != -1) {
        while (nums[r] < next && nums[r] > nums[l])
            next = nums[r--]
        ans += n - r
    }
    while (nums[r] < next)
        next = nums[r--]
    return ans + n - r
}