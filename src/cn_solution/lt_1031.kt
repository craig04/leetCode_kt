package cn_solution

fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
    val n = nums.size
    fun maxSum(firstLen: Int, secondLen: Int): Int {
        var first = (0 until firstLen).sumBy { nums[it] }
        var second = (0 until secondLen).sumBy { nums[firstLen + it] }
        var max = first
        var result = first + second
        var i = firstLen
        var j = firstLen + secondLen
        while (j != n) {
            first += nums[i] - nums[i - firstLen]
            max = maxOf(max, first)
            second += nums[j++] - nums[i++]
            result = maxOf(result, max + second)
        }
        return result
    }
    return maxOf(maxSum(firstLen, secondLen), maxSum(secondLen, firstLen))
}