package cn_offer

fun missingNumber(nums: IntArray): Int {
    var l = 0
    var r = nums.size
    while (l != r) {
        when (val m = (l + r) shr 1) {
            nums[m] -> l = m + 1
            else -> r = m
        }
    }
    return r
}