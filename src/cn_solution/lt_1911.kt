package cn_solution

fun maxAlternatingSum(nums: IntArray): Long {
    var odd = nums[0].toLong()
    var even = 0L
    for (i in 1 until nums.size) {
        val n = nums[i]
        val temp = odd
        odd = maxOf(odd, even + n)
        even = maxOf(even, temp - n)
    }
    return odd
}