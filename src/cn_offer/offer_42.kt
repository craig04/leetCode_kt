package cn_offer

fun maxSubArray(nums: IntArray): Int {
    var temp = 0
    return nums.fold(nums[0]) { res, n ->
        temp = maxOf(n, temp + n)
        maxOf(res, temp)
    }
}