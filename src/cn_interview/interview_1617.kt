package cn_interview

fun maxSubArray(nums: IntArray): Int {
    var sum = 0
    return nums.fold(Int.MIN_VALUE) { res, n ->
        sum += n
        maxOf(res, sum).apply { sum = maxOf(sum, 0) }
    }
}