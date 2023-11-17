package cn_solution

fun maxSubArray(nums: IntArray): Int {
    var temp = 0
    return nums.maxOf {
        temp = maxOf(it, temp + it)
        temp
    }
}