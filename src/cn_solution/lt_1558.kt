package cn_solution

private fun minOperations(nums: IntArray): Int {
    var max = 0
    var bit = 0
    for (num in nums) {
        max = maxOf(max, num)
        bit += num.countOneBits()
    }
    return 32 - max.shr(1).countLeadingZeroBits() + bit
}