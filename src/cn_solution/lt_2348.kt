package cn_solution

fun zeroFilledSubarray(nums: IntArray): Long {
    var ans = 0L
    var l = -1
    for (r in nums.indices) {
        if (nums[r] != 0)
            l = r
        ans += r - l
    }
    return ans
}