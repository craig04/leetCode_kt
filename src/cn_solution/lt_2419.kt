package cn_solution

private fun longestSubarray(nums: IntArray): Int {
    var ans = 0
    var len = 0
    var max = Int.MIN_VALUE
    for (num in nums) {
        if (num > max) {
            ans = 1
            len = 1
            max = num
        } else if (num == max) {
            len++
            ans = maxOf(ans, len)
        } else {
            len = 1
        }
    }
    return ans
}