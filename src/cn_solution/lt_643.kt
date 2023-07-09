package cn_solution

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var sum = (0 until k - 1).sumBy { nums[it] }
    return (k - 1 until nums.size).fold(Int.MIN_VALUE) { res, i ->
        sum += nums[i]
        maxOf(sum, res).apply { sum -= nums[i - k + 1] }
    } / k.toDouble()
}