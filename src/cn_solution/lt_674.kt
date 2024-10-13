package cn_solution

fun findLengthOfLCIS(nums: IntArray): Int {
    val n = nums.size
    var i = 0
    var ans = 0
    while (i != n) {
        var j = i + 1
        while (j != n && nums[j - 1] < nums[j])
            j++
        ans = maxOf(ans, j - i)
        i = j
    }
    return ans
}