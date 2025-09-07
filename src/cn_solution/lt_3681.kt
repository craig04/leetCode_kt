package cn_solution

fun maxXorSubsequences(nums: IntArray): Int {
    val w = 32 - nums.max().countLeadingZeroBits()
    val b = IntArray(w)
    for (i in nums.indices) {
        var num = nums[i]
        while (num != 0) {
            val j = 31 - num.countLeadingZeroBits()
            if (b[j] == 0) {
                b[j] = num
                break
            }
            num = num xor b[j]
        }
    }
    return (w - 1 downTo 0).fold(0) { ans, i ->
        maxOf(ans, ans xor b[i])
    }
}