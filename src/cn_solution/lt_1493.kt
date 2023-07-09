package cn_solution

fun longestSubarray(nums: IntArray): Int {
    var pre = 0
    var cur = 0
    var result = 0
    for (n in nums) {
        if (n == 1) {
            cur++
            result = maxOf(result, cur + pre)
        } else {
            pre = cur
            cur = 0
        }
    }
    return minOf(nums.size - 1, result)
}