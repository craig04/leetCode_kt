package cn_solution

fun longestNiceSubarray(nums: IntArray): Int {
    var x = 0
    var i = 0
    var ans = 0
    for (j in nums.indices) {
        val num = nums[j]
        while (num and x != 0)
            x = nums[i++] xor x
        x = x or nums[j]
        ans = maxOf(ans, j - i + 1)
    }
    return ans
}