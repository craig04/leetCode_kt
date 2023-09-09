package cn_lcr

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var i = 0
    var sum = 0
    var result = Int.MAX_VALUE
    for (j in nums.indices) {
        sum += nums[j]
        while (sum >= target) {
            result = minOf(result, j - i + 1)
            sum -= nums[i++]
        }
    }
    return if (result == Int.MAX_VALUE) 0 else result
}