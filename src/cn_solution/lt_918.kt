package cn_solution

fun maxSubarraySumCircular(nums: IntArray): Int {
    var sum = 0
    var preMax = 0
    var preMin = 0
    var maxRes = Int.MIN_VALUE
    var minRes = Int.MAX_VALUE
    for (n in nums.indices) {
        preMax = maxOf(preMax + n, n)
        maxRes = maxOf(maxRes, preMax)
        preMin = minOf(preMin + n, n)
        minRes = minOf(minRes, preMin)
        sum += n
    }
    return if (maxRes < 0) maxRes else maxOf(maxRes, sum - minRes)
}