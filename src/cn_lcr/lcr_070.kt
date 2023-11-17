package cn_lcr

fun singleNonDuplicate(nums: IntArray): Int {
    var l = 0
    var r = nums.lastIndex
    while (l != r) {
        val m = (l + r) shr 1
        if (nums[m] == nums[m xor 1]) {
            l = m + 1
        } else {
            r = m
        }
    }
    return nums[l]
}