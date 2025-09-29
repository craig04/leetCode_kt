package cn_solution

fun longestSubarray(nums: IntArray): Int {
    val n = nums.size
    var i = 2
    var ans = 2
    while (i < n) {
        var j = i
        while (j < n && nums[j - 2] + nums[j - 1] == nums[j])
            j++
        ans = maxOf(ans, j - i + 2)
        i = j + 1
    }
    return ans
}